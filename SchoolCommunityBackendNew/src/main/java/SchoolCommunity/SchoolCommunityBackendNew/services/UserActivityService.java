package SchoolCommunity.SchoolCommunityBackendNew.services;

import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityBrief;
import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityBasicInfo;
import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityNeeded;
import SchoolCommunity.SchoolCommunityBackendNew.model.Requirement;
import com.github.pagehelper.PageInfo;

public interface UserActivityService {
    Status publish(ActivityBasicInfo activityBasicInfo, Requirement requirement);

    Status publish(ActivityBasicInfo activityBasicInfo, ActivityNeeded activityNeeded);

    Status deleteActivity(long activityId, long userId);

    PageInfo<ActivityBrief> myActivity(long userid,int pageNum);
}
