package SchoolCommunity.SchoolCommunityBackendNew.services.serviceImpl;

import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityBrief;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.ActivityBasicInfoMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.CommunityMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.CorporationMapper;
import SchoolCommunity.SchoolCommunityBackendNew.model.*;
import SchoolCommunity.SchoolCommunityBackendNew.services.BrowseService;
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

    @Override
    public ArrayList<ActivityBrief> getActivityListByPage(int pageNum, int pageSize) {
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
                activityBrief.setActicityName(a.getActivityname());
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
            return activityBriefArrayList;
        }

        return null;
    }

    @Override
    public PageInfo<ActivityBrief> getPageInfo(int pageNum, int pageSize) {
        return null;
    }
}
