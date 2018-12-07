package SchoolCommunity.SchoolCommunityBackendNew.services.serviceImpl;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.CommunityMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.CorporationMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.ManageMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.UserInfoMapper;
import SchoolCommunity.SchoolCommunityBackendNew.model.*;
import SchoolCommunity.SchoolCommunityBackendNew.services.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("ManageService")
@Transactional
public class ManageServiceImpl implements ManageService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private CorporationMapper corporationMapper;

    @Autowired
    private ManageMapper manageMapper;

    @Override
    public List<Community> getCommunityRequestInfo(long userid, int type) {
        List<Community> communityList;
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userid);
        int userType = userInfo.getRoleid();
        if (userType != type || type != 1) {
            communityList = null;
        } else {
            ManageExample manageExample = new ManageExample();
            ManageExample.Criteria manageCriteria = manageExample.createCriteria();
            manageCriteria.andManageruseridEqualTo(userid);

            List<Manage> manageList = manageMapper.selectByExample(manageExample);
            if (!manageList.isEmpty()) {
                CommunityExample communityExample = new CommunityExample();
                CommunityExample.Criteria communityCriteria = communityExample.createCriteria();
                ArrayList<Long> useridList = new ArrayList<>();
                for (Manage manager : manageList) {
                    useridList.add(manager.getInterviwee());
                }

                UserInfoExample userInfoExample = new UserInfoExample();
                UserInfoExample.Criteria userInfoCriteria = userInfoExample.createCriteria();
                userInfoCriteria.andUseridIn(useridList);

                List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
                if (!useridList.isEmpty()) {
                    useridList.clear();
                    for (UserInfo user : userInfoList) {
                        if (user.getSent() == 1) {
                            useridList.add(user.getUserid());
                        }
                    }
                    communityCriteria.andUseridIn(useridList);

                    communityList = communityMapper.selectByExample(communityExample);
                } else {
                    communityList = null;
                }
            } else {
                communityList = null;
            }
        }
        return communityList;
    }

    @Override
    public List<Corporation> getCorporationRequestInfo(long userid, int type) {
        List<Corporation> corporationList;
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userid);
        int userType = userInfo.getRoleid();
        if (userType != type || type != 0) {
            corporationList = null;
        } else {
            ManageExample manageExample = new ManageExample();
            ManageExample.Criteria mangeCriteria = manageExample.createCriteria();
            mangeCriteria.andManageruseridEqualTo(userid);

            List<Manage> mangeList = manageMapper.selectByExample(manageExample);
            if (!mangeList.isEmpty()) {
                CorporationExample corporationExample = new CorporationExample();
                CorporationExample.Criteria corporationCriteria = corporationExample.createCriteria();
                ArrayList<Long> useridList = new ArrayList<>();
                for (Manage manager : mangeList) {
                    useridList.add(manager.getInterviwee());
                }
                UserInfoExample userInfoExample = new UserInfoExample();
                UserInfoExample.Criteria userInfoCriteria = userInfoExample.createCriteria();
                userInfoCriteria.andUseridIn(useridList);

                List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
                if (!useridList.isEmpty()) {
                    useridList.clear();
                    for (UserInfo user : userInfoList) {
                        if (user.getSent() == 1) {
                            useridList.add(user.getUserid());
                        }
                    }
                    corporationCriteria.andUseridIn(useridList);

                    corporationList = corporationMapper.selectByExample(corporationExample);
                } else {
                    corporationList = null;
                }
            } else {
                corporationList = null;
            }
        }
        return corporationList;
    }

    @Override
    public Status verify(long managerid, long userid) {
        Status status;
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(managerid);
        if (userInfo == null || userInfo.getRoleid() != 0 || userInfo.getRoleid() != 1) {
            status = Status.NOPERMISSION;
        } else {
            UserInfo interviewee = userInfoMapper.selectByPrimaryKey(userid);
            if (interviewee == null || interviewee.getSent() == 0) {
                status = Status.NOTEXISTS;
            } else if (interviewee.getStatus() == 1) {
                status = Status.VERIFIED;
            } else {
                interviewee.setStatus(1);
                int row = userInfoMapper.updateByPrimaryKeySelective(interviewee);
                if (row != 1) {
                    status = Status.FAILED;
                } else {
                    status = Status.SUCCESS;
                }
            }
        }
        return status;
    }

    @Override
    public Status cancleVerify(long managerid, long userid) {
        Status status;
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(managerid);
        if (userInfo == null || userInfo.getRoleid() != 1 || userInfo.getRoleid() != 0) {
            status = Status.NOPERMISSION;
        } else {
            UserInfo interviewee = userInfoMapper.selectByPrimaryKey(userid);
            if (interviewee == null || interviewee.getSent() == 0) {
                status = Status.NOTEXISTS;
            } else {
                interviewee.setStatus(0);
                int row = userInfoMapper.updateByPrimaryKeySelective(interviewee);
                if (row != 1) {
                    status = Status.FAILED;
                } else {
                    status = Status.SUCCESS;
                }
            }
        }
        return status;
    }
}
