package SchoolCommunity.SchoolCommunityBackendNew.services;

import SchoolCommunity.SchoolCommunityBackendNew.model.Community;

import java.util.List;

public interface ManageService {

    List<Community> getCommunityRequestInfo(long userid, int type);
}
