package SchoolCommunity.SchoolCommunityBackendNew.services;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.model.Community;
import SchoolCommunity.SchoolCommunityBackendNew.model.Corporation;

import java.util.List;

public interface ManageService {

    List<Community> getCommunityRequestInfo(long userid, int type);

    List<Corporation> getCorporationRequestInfo(long userid, int type);

    Status verify(long managerid, long userid);

    Status cancleVerify(long managerid, long userid);
}
