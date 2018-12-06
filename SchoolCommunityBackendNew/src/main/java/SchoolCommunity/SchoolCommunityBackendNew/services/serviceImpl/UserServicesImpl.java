package SchoolCommunity.SchoolCommunityBackendNew.services.serviceImpl;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.LogMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.UserInfoMapper;
import SchoolCommunity.SchoolCommunityBackendNew.model.Log;
import SchoolCommunity.SchoolCommunityBackendNew.model.LogExample;
import SchoolCommunity.SchoolCommunityBackendNew.model.UserInfo;
import SchoolCommunity.SchoolCommunityBackendNew.model.UserInfoExample;
import SchoolCommunity.SchoolCommunityBackendNew.services.UserService;
import com.alibaba.fastjson.JSON;
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

    @Override
    public String login(String userName, String pwd) {
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
            return JSON.toJSONString(status);
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
            return JSON.toJSONString(status);
        } else {
            status.put("STATUS", Status.SUCCESS.getName());
            status.put("TYPE", null);
            return JSON.toJSONString(status);
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
}
