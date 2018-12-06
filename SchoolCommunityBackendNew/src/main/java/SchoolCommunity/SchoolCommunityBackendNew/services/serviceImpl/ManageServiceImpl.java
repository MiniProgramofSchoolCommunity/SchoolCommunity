package SchoolCommunity.SchoolCommunityBackendNew.services.serviceImpl;

import SchoolCommunity.SchoolCommunityBackendNew.mappers.CommunityMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.CorporationMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.ManageMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.UserInfoMapper;
import SchoolCommunity.SchoolCommunityBackendNew.model.*;
import SchoolCommunity.SchoolCommunityBackendNew.services.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ManageService")
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
                    useridList.add(manager.getManageruserid());
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
}
