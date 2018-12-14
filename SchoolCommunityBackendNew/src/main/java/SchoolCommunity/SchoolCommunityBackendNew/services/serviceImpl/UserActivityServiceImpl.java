package SchoolCommunity.SchoolCommunityBackendNew.services.serviceImpl;

import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityBrief;
import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.*;
import SchoolCommunity.SchoolCommunityBackendNew.model.*;
import SchoolCommunity.SchoolCommunityBackendNew.services.UserActivityService;
import SchoolCommunity.SchoolCommunityBackendNew.services.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("UserActivityService")
@Transactional
public class UserActivityServiceImpl implements UserActivityService {

    @Autowired
    private UserService userService;

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

    @Override
    public Status deleteActivity(long activityId, long userId) {
        Status result;
        ActivityBasicInfo activityBasicInfo = activityBasicInfoMapper.selectByPrimaryKey(activityId);
        if (activityBasicInfo != null) {
            if (activityBasicInfo.getPublisherid() == userId) {
                if (activityBasicInfo.getType() == 0) {
                    int row = requirementMapper.deleteByPrimaryKey(activityId);
                    if (row != 1) {
                        result = Status.FAILED;
                        return result;
                    }
                } else {
                    int row = activityNeededMapper.deleteByPrimaryKey(activityId);
                    if (row != 1) {
                        result = Status.FAILED;
                        return result;
                    }
                }
                int row = activityBasicInfoMapper.deleteByPrimaryKey(activityId);
                if (row == 1) {
                    result = Status.SUCCESS;
                } else {
                    result = Status.FAILED;
                }
            } else {
                result = Status.NOPERMISSION;
            }
        } else {
            result = Status.NOTEXISTS;
        }
        return result;
    }

    @Override
    public PageInfo<ActivityBrief> myActivity(long userid, int pageNum) {
        Status userStatus = userService.isVerified(userid);
        PageInfo<ActivityBrief> result = null;
        if (userStatus == Status.VERIFIED) {
            ActivityBasicInfoExample activityBasicInfoExample = new ActivityBasicInfoExample();
            ActivityBasicInfoExample.Criteria activityCriteria = activityBasicInfoExample.createCriteria();
            activityCriteria.andPublisheridEqualTo(userid);

            PageHelper.startPage(pageNum, 10);
            List<ActivityBasicInfo> activityBasicInfoList = activityBasicInfoMapper.selectByExample(activityBasicInfoExample);
            PageInfo<ActivityBasicInfo> activityBasicInfoPageInfo = new PageInfo<>(activityBasicInfoList);

            if (!activityBasicInfoList.isEmpty()) {
                ArrayList<Long> activityIdList = new ArrayList<>();
                for (ActivityBasicInfo a : activityBasicInfoList) {
                    activityIdList.add(a.getActivityid());
                }
                String sponsorName = null;
                int sLevel = 2;
                int type = activityBasicInfoList.get(0).getType();
                if (type == 1) {
                    ActivityNeededExample activityNeededExample = new ActivityNeededExample();
                    ActivityNeededExample.Criteria criteria = activityNeededExample.createCriteria();
                    criteria.andActivityidIn(activityIdList);
                    List<ActivityNeeded> activityNeededList = activityNeededMapper.selectByExample(activityNeededExample);
                    Corporation corporation = corporationMapper.selectByPrimaryKey(userid);
                    sponsorName = corporation.getCname();
                } else if (type == 0) {
                    RequirementExample requirementExample = new RequirementExample();
                    RequirementExample.Criteria criteria = requirementExample.createCriteria();
                    criteria.andActivityidIn(activityIdList);
                    List<Requirement> requirementList = requirementMapper.selectByExample(requirementExample);
                    Community community = communityMapper.selectByPrimaryKey(userid);
                    sponsorName = community.getSname();
                    sLevel = community.getSlevel();
                } else {
                    return null;
                }
                ArrayList<ActivityBrief> activityBriefArrayList = new ArrayList<>();
                for (ActivityBasicInfo a : activityBasicInfoList) {
                    ActivityBrief activityBrief = new ActivityBrief();
                    activityBrief.setAddress(a.getActivityaddress());
                    activityBrief.setActivityName(a.getActivityname());
                    Date date = new Date(a.getDate().getTime() + a.getTime().getTime());
                    activityBrief.setDate(date);
                    activityBrief.setType(a.getType());
                    activityBrief.setId(a.getActivityid());
                    activityBrief.setSponsorName(sponsorName);
                    if (type == 0) {
                        activityBrief.setsLevel(sLevel);
                    }
                    activityBriefArrayList.add(activityBrief);
                }
                result = new PageInfo<>(activityBriefArrayList);
                result.setEndRow(activityBasicInfoPageInfo.getEndRow());
                result.setHasNextPage(activityBasicInfoPageInfo.isHasNextPage());
                result.setHasPreviousPage(activityBasicInfoPageInfo.isHasPreviousPage());
                result.setIsFirstPage(activityBasicInfoPageInfo.isIsFirstPage());
                result.setIsLastPage(activityBasicInfoPageInfo.isIsLastPage());
                result.setNavigateFirstPage(activityBasicInfoPageInfo.getNavigateFirstPage());
                result.setNavigateLastPage(activityBasicInfoPageInfo.getNavigateLastPage());
                result.setNavigatePages(activityBasicInfoPageInfo.getNavigatePages());
                result.setNavigatepageNums(activityBasicInfoPageInfo.getNavigatepageNums());
                result.setNextPage(activityBasicInfoPageInfo.getNextPage());
                result.setPageNum(activityBasicInfoPageInfo.getPageNum());
                result.setPageSize(activityBasicInfoPageInfo.getPageSize());
                result.setPages(activityBasicInfoPageInfo.getPages());
                result.setPrePage(activityBasicInfoPageInfo.getPrePage());
                result.setSize(activityBasicInfoPageInfo.getSize());
                result.setStartRow(activityBasicInfoPageInfo.getStartRow());
                result.setTotal(activityBasicInfoPageInfo.getTotal());
            }
        } else {
            result = null;
        }
        return result;
    }
}
