package SchoolCommunity.SchoolCommunityBackendNew.services;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityBasicInfo;
import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityNeeded;
import SchoolCommunity.SchoolCommunityBackendNew.model.Requirement;

public interface UserActivityService {
    Status publish(ActivityBasicInfo activityBasicInfo, Requirement requirement);

    Status publish(ActivityBasicInfo activityBasicInfo, ActivityNeeded activityNeeded);

    Status deleteActivity(long activityId, long userId);
}
