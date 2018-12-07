package SchoolCommunity.SchoolCommunityBackendNew.services.serviceImpl;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.CommunityMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.CorporationMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.LogMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.UserInfoMapper;
import SchoolCommunity.SchoolCommunityBackendNew.model.*;
import SchoolCommunity.SchoolCommunityBackendNew.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("UserService")
// 事务管理
@Transactional
public class UserServicesImpl implements UserService {

    @Autowired
    private LogMapper logMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private CorporationMapper corporationMapper;

    @Override
    public Map<String, String> login(String userName, String pwd) {
        Map<String, String> status = new HashMap<>();

        LogExample userLogCriteria = new LogExample();
        LogExample.Criteria criteria = userLogCriteria.createCriteria();
        criteria.andUsernameEqualTo(userName);

        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria userInfoCriteria = userInfoExample.createCriteria();

        List<Log> userLogList = logMapper.selectByExample(userLogCriteria);

        if (userLogList.isEmpty()) {
            status.put("STATUS", Status.NOTEXISTS.getName());
            status.put("TYPE", null);
            status.put("USERID", null);
            return status;
        }

        Log user = userLogList.get(0);
        userInfoCriteria.andUseridEqualTo(user.getUserid());
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
        UserInfo userInfo = userInfoList.get(0);

        criteria.andPwdEqualTo(pwd);
        long userLogStatus = logMapper.countByExample(userLogCriteria);
        if (userLogStatus != 1) {
            status.put("STATUS", Status.PWDERROR.getName());
            status.put("TYPE", null);
            status.put("USERID", null);
            return status;
        } else {
            status.put("STATUS", Status.SUCCESS.getName());
            status.put("TYPE", userInfo.getRoleid().toString());
            status.put("USERID", user.getUserid().toString());
            return status;
        }
    }

    @Override
    public Status reister(Log user, UserInfo userInfo) {
        Status registerStatus;

        LogExample logRegisterCriteria = new LogExample();
        UserInfoExample userInfoRegisterCriteria = new UserInfoExample();
        UserInfoExample.Criteria userInfoCriteria = userInfoRegisterCriteria.createCriteria();
        LogExample.Criteria logCriteria = logRegisterCriteria.createCriteria();
        logCriteria.andUsernameEqualTo(user.getUsername());
        userInfoCriteria.andEmailEqualTo(userInfo.getEmail());
        long existedUser = logMapper.countByExample(logRegisterCriteria);
        long existedEmail = userInfoMapper.countByExample(userInfoRegisterCriteria);
        if (existedUser != 0 || existedEmail != 0) {
            return Status.EXISTED;
        }

        int rows = logMapper.insert(user);
        if (rows == 1) {
            registerStatus = Status.SUCCESS;
            long pk = user.getUserid();
            userInfo.setUserid(pk);
            rows = userInfoMapper.insertSelective(userInfo);
            if (rows != 1) {
                registerStatus = Status.FAILED;

            }
        } else {
            registerStatus = Status.FAILED;
        }
        return registerStatus;
    }

    @Override
    public Status isVerified(long userid) {
        Status status = Status.NOTEXISTS;
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUseridEqualTo(userid);

        List<UserInfo> list = userInfoMapper.selectByExample(userInfoExample);
        if (!list.isEmpty()) {
            int verfyStatus = list.get(0).getStatus();
            int sent = list.get(0).getSent();
            if (verfyStatus != 0) {
                status = Status.VERIFIED;
            } else {
                status = Status.NOPERMISSION;
            }
        }

        return status;
    }

    @Override
    public Status verifyRequest(long userid, Community community) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userid);

        if (userInfo != null) {
            userInfo.setSent(1);
            int row = communityMapper.insert(community);
            if (row != 1) {
                return Status.FAILED;
            }
            row = userInfoMapper.updateByPrimaryKeySelective(userInfo);
            if (row != 1) {
                return Status.FAILED;
            }
            return Status.SUCCESS;
        }
        return Status.NOTEXISTS;
    }

    @Override
    public Status verifyRequest(long userid, Corporation corporation) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userid);
        if (userInfo != null) {
            userInfo.setSent(1);
            int row = corporationMapper.insert(corporation);
            if (row != 1) {
                return Status.FAILED;
            }
            row = userInfoMapper.updateByPrimaryKeySelective(userInfo);
            if (row != 1) {
                return Status.FAILED;
            }
            return Status.SUCCESS;
        }
        return Status.NOTEXISTS;
    }

}
