package SchoolCommunity.SchoolCommunityBackendNew.services;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.model.Community;
import SchoolCommunity.SchoolCommunityBackendNew.model.Corporation;
import com.github.pagehelper.PageInfo;

public interface ManageService {

    PageInfo<Community> getCommunityRequestInfo(long userid, int type, int pageNum);

    PageInfo<Corporation> getCorporationRequestInfo(long userid, int type, int pageNum);

    Status verify(long managerid, long userid);

    Status cancleVerify(long managerid, long userid);
}
