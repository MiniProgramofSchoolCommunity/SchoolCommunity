package SchoolCommunity.SchoolCommunityBackendNew.services;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.model.Log;
import SchoolCommunity.SchoolCommunityBackendNew.model.UserInfo;

public interface UserService {
    String login(String userName, String pwd);
    Status reister(Log user, UserInfo userInfo);
}
