package SchoolCommunity.SchoolCommunityBackendNew.services.serviceImpl;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.*;
import SchoolCommunity.SchoolCommunityBackendNew.model.*;
import SchoolCommunity.SchoolCommunityBackendNew.services.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserActivityService")
@Transactional
public class UserActivityServiceImpl implements UserActivityService {

    @Autowired
    private ActivityBasicInfoMapper activityBasicInfoMapper;

    @Autowired
    private ActivityNeededMapper activityNeededMapper;

    @Autowired
    private RequirementMapper requirementMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private CorporationMapper corporationMapper;

    @Override
    public Status publish(ActivityBasicInfo activityBasicInfo, Requirement requirement) {
        int row = activityBasicInfoMapper.insertSelective(activityBasicInfo);
        if (row != 1) {
            return Status.FAILED;
        }
        requirement.setActivityid(activityBasicInfo.getActivityid());

        CommunityExample communityExample = new CommunityExample();
        CommunityExample.Criteria communityCriteria = communityExample.createCriteria();
        communityCriteria.andUseridEqualTo(activityBasicInfo.getPublisherid());

        List<Community> communityList = communityMapper.selectByExample(communityExample);
        if (!communityList.isEmpty()) {
            Community community = communityList.get(0);
            requirement.setSname(community.getSchool() + community.getSname());
            requirement.setSlevel(community.getSlevel());
            requirement.setSleadername(community.getSleadername());
            requirement.setSleadernum(community.getSleadernum());
            requirement.setContactsname(community.getContactsname());
            requirement.setContactsnum(community.getContactsnum());

            row = requirementMapper.insert(requirement);
            if (row != 1) {
                return Status.FAILED;
            }
        }
        return Status.SUCCESS;
    }

    @Override
    public Status publish(ActivityBasicInfo activityBasicInfo, ActivityNeeded activityNeeded) {
        int row = activityBasicInfoMapper.insertSelective(activityBasicInfo);
        if (row != 1) {
            return Status.FAILED;
        }
        activityNeeded.setActivityid(activityBasicInfo.getActivityid());

        CorporationExample corporationExample = new CorporationExample();
        CorporationExample.Criteria corporationCriteria = corporationExample.createCriteria();
        corporationCriteria.andUseridEqualTo(activityBasicInfo.getPublisherid());

        List<Corporation> corporationList = corporationMapper.selectByExample(corporationExample);
        if (!corporationList.isEmpty()) {
            Corporation corporation = corporationList.get(0);
            activityNeeded.setCleadername(corporation.getCleadername());
            activityNeeded.setCleadernum(corporation.getCleadernum());
            activityNeeded.setCname(corporation.getCname());
            activityNeeded.setContactsname(corporation.getContactsname());
            activityNeeded.setContactsnum(corporation.getContactsnum());

            row = activityNeededMapper.insert(activityNeeded);
            if (row != 1) {
                return Status.FAILED;
            }
        }
        return Status.SUCCESS;
    }
}
