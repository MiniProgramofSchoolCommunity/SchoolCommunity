package SchoolCommunity.SchoolCommunityBackendNew.services;

import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityBrief;
import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityDetail;
import com.github.pagehelper.PageInfo;


public interface BrowseService {
    PageInfo<ActivityBrief> getActivityListByPage(int pageNum, int pageSize);

    // todo 页面信息接口
    PageInfo<ActivityBrief> getPageInfo(int pageNum, int pageSize);

    ActivityDetail getActivityDetail(long activityId, int type);
}
