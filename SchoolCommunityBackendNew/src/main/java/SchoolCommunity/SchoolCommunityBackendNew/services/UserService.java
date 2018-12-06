package SchoolCommunity.SchoolCommunityBackendNew.services;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.model.Community;
import SchoolCommunity.SchoolCommunityBackendNew.model.Corporation;
import SchoolCommunity.SchoolCommunityBackendNew.model.Log;
import SchoolCommunity.SchoolCommunityBackendNew.model.UserInfo;

import java.util.Map;

public interface UserService {
    Map<String, String> login(String userName, String pwd);

    Status reister(Log user, UserInfo userInfo);

    Status isVerified(long userid);

    Status verifyRequest(long userid, Community community);

    Status verifyRequest(long userid, Corporation corporation);

}
