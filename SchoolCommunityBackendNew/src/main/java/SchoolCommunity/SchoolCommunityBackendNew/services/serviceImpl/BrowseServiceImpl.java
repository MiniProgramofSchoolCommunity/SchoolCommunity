package SchoolCommunity.SchoolCommunityBackendNew.services.serviceImpl;

import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityBrief;
import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityDetail;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.*;
import SchoolCommunity.SchoolCommunityBackendNew.model.*;
import SchoolCommunity.SchoolCommunityBackendNew.services.BrowseService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("BrowseService")
public class BrowseServiceImpl implements BrowseService {
    @Autowired
    private ActivityBasicInfoMapper activityBasicInfoMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private CorporationMapper corporationMapper;

    @Autowired
    private RequirementMapper requirementMapper;

    @Autowired
    private ActivityNeededMapper activityNeededMapper;

    @Override
    public PageInfo<ActivityBrief> getActivityListByPage(int pageNum, int pageSize) {
        ActivityBasicInfoExample activityBasicInfoExample = new ActivityBasicInfoExample();
        ActivityBasicInfoExample.Criteria activityBasicInfoCrteria = activityBasicInfoExample.createCriteria();

        CommunityExample communityExample = new CommunityExample();
        CommunityExample.Criteria communityCriteria = communityExample.createCriteria();

        CorporationExample corporationExample = new CorporationExample();
        CorporationExample.Criteria corporationCriteria = corporationExample.createCriteria();

        PageHelper.startPage(pageNum, pageSize, "date desc");
        List<ActivityBasicInfo> basicInfoList = activityBasicInfoMapper.selectByExample(activityBasicInfoExample);
        PageInfo<ActivityBasicInfo> activityBasicInfoPageInfo = new PageInfo<>(basicInfoList);

        if (!basicInfoList.isEmpty()) {
            ArrayList<Long> useridList = new ArrayList<>();
            for (ActivityBasicInfo info : basicInfoList) {
                useridList.add(info.getPublisherid());
            }
            communityCriteria.andUseridIn(useridList);
            corporationCriteria.andUseridIn(useridList);
            List<Community> communityList = communityMapper.selectByExample(communityExample);
            List<Corporation> corporationList = corporationMapper.selectByExample(corporationExample);

            Map<Long, Community> communityMap = new HashMap<>();
            for (Community community : communityList) {
                communityMap.put(community.getUserid(), community);
            }

            Map<Long, Corporation> corporationMap = new HashMap<>();
            for (Corporation corporation : corporationList) {
                corporationMap.put(corporation.getUserid(), corporation);
            }
            ArrayList<ActivityBrief> activityBriefArrayList = new ArrayList<>();
            for (ActivityBasicInfo a : basicInfoList) {
                ActivityBrief activityBrief = new ActivityBrief();
                activityBrief.setAddress(a.getActivityaddress());
                activityBrief.setActivityName(a.getActivityname());
                Date date = new Date(a.getDate().getTime() + a.getTime().getTime());
                activityBrief.setDate(date);
                activityBrief.setType(a.getType());
                activityBrief.setId(a.getActivityid());
                if (a.getType() == 0) {
                    activityBrief.setsLevel(communityMap.get(a.getPublisherid()).getSlevel());
                    activityBrief.setSponsorName(communityMap.get(a.getPublisherid()).getSname());
                } else {
                    activityBrief.setSponsorName(corporationMap.get(a.getPublisherid()).getCname());
                }
                activityBriefArrayList.add(activityBrief);
            }
            PageInfo<ActivityBrief> activityBriefPageInfo = new PageInfo<>(activityBriefArrayList);
            activityBriefPageInfo.setEndRow(activityBasicInfoPageInfo.getEndRow());
            activityBriefPageInfo.setHasNextPage(activityBasicInfoPageInfo.isHasNextPage());
            activityBriefPageInfo.setHasPreviousPage(activityBasicInfoPageInfo.isHasPreviousPage());
            activityBriefPageInfo.setIsFirstPage(activityBasicInfoPageInfo.isIsFirstPage());
            activityBriefPageInfo.setIsLastPage(activityBasicInfoPageInfo.isIsLastPage());
            activityBriefPageInfo.setNavigateFirstPage(activityBasicInfoPageInfo.getNavigateFirstPage());
            activityBriefPageInfo.setNavigateLastPage(activityBasicInfoPageInfo.getNavigateLastPage());
            activityBriefPageInfo.setNavigatePages(activityBasicInfoPageInfo.getNavigatePages());
            activityBriefPageInfo.setNavigatepageNums(activityBasicInfoPageInfo.getNavigatepageNums());
            activityBriefPageInfo.setNextPage(activityBasicInfoPageInfo.getNextPage());
            activityBriefPageInfo.setPageNum(activityBasicInfoPageInfo.getPageNum());
            activityBriefPageInfo.setPageSize(activityBasicInfoPageInfo.getPageSize());
            activityBriefPageInfo.setPages(activityBasicInfoPageInfo.getPages());
            activityBriefPageInfo.setPrePage(activityBasicInfoPageInfo.getPrePage());
            activityBriefPageInfo.setSize(activityBasicInfoPageInfo.getSize());
            activityBriefPageInfo.setStartRow(activityBasicInfoPageInfo.getStartRow());
            activityBriefPageInfo.setTotal(activityBasicInfoPageInfo.getTotal());
            return activityBriefPageInfo;
        }

        return null;
    }

    @Override
    public PageInfo<ActivityBrief> getPageInfo(int pageNum, int pageSize) {

        return null;
    }

    @Override
    public ActivityDetail getActivityDetail(long activityId, int type) {
        ActivityBasicInfo activityBasicInfo = activityBasicInfoMapper.selectByPrimaryKey(activityId);
        ActivityDetail activityDetail = null;
        if (activityBasicInfo != null) {
            activityDetail = new ActivityDetail();
            if (type == 0) {
                Requirement requirement = requirementMapper.selectByPrimaryKey(activityId);
                if (requirement != null) {
                    activityDetail.setActivityAddress(activityBasicInfo.getActivityaddress());
                    activityDetail.setActivityId(activityBasicInfo.getActivityid());
                    activityDetail.setActivityIntro(activityBasicInfo.getActivityintro());
                    activityDetail.setActivityName(activityBasicInfo.getActivityname());
                    activityDetail.setContactsName(requirement.getContactsname());
                    activityDetail.setContactsNum(requirement.getContactsnum());
                    activityDetail.setDate(activityBasicInfo.getDate());
                    activityDetail.setLeaderName(requirement.getSleadername());
                    activityDetail.setLeaderNum(requirement.getSleadernum());
                    activityDetail.setLevel(requirement.getSlevel());
                    activityDetail.setRequirementOfSponsorship(requirement.getRequirement());
                    activityDetail.setTime(activityBasicInfo.getTime());
                    activityDetail.setSponsor(requirement.getSname());
                    activityDetail.setType(0);

                } else {
                    activityDetail = null;
                }
            } else if (type == 1) {
                ActivityNeeded activityNeeded = activityNeededMapper.selectByPrimaryKey(activityId);
                if (activityNeeded != null) {
                    activityDetail.setActivityAddress(activityBasicInfo.getActivityaddress());
                    activityDetail.setActivityId(activityBasicInfo.getActivityid());
                    activityDetail.setActivityIntro(activityBasicInfo.getActivityintro());
                    activityDetail.setActivityName(activityBasicInfo.getActivityname());
                    activityDetail.setContactsName(activityNeeded.getContactsname());
                    activityDetail.setContactsNum(activityNeeded.getContactsnum());
                    activityDetail.setDate(activityBasicInfo.getDate());
                    activityDetail.setLeaderName(activityNeeded.getCleadername());
                    activityDetail.setLeaderNum(activityNeeded.getCleadernum());
                    activityDetail.setTime(activityBasicInfo.getTime());
                    activityDetail.setSponsor(activityNeeded.getCname());
                    activityDetail.setType(1);
                    activityDetail.setRequirementOfActivity(activityNeeded.getRequirement());
                    activityDetail.setSponsorshipIntro(activityNeeded.getSponsorship());
                }
            } else {
                activityDetail = null;
            }
        }
        return activityDetail;
    }
}
