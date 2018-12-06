package SchoolCommunity.SchoolCommunityBackendNew.services;

import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityBrief;
import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityDetail;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;


public interface BrowseService {
    // todo 活动简略信息接口
    ArrayList<ActivityBrief> getActivityListByPage(int pageNum, int pageSize);

    // todo 页面信息接口
    PageInfo<ActivityBrief> getPageInfo(int pageNum, int pageSize);

    // todo 活动详细信息
    ActivityDetail getActivityDetail(long activityId, int type);
}
