package SchoolCommunity.SchoolCommunityBackendNew;

import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityBrief;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.ActivityBasicInfoMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.CommunityMapper;
import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityBasicInfo;
import SchoolCommunity.SchoolCommunityBackendNew.services.BrowseService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class BrowseServiceTest extends TestClass {

    @Autowired
    private BrowseService browseService;

    @Autowired
    private ActivityBasicInfoMapper activityBasicInfoMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Test
    @Transactional
    @Rollback()
    public void getActivituList() {
        ActivityBasicInfo activityBasicInfo = new ActivityBasicInfo();
        activityBasicInfo.setActivityname("wht");
        activityBasicInfo.setActivityaddress("ymx");
        activityBasicInfo.setActivityintro("stt");
        activityBasicInfo.setPublisherid((long) 1);
        activityBasicInfo.setType(0);
        Date date = new Date();
        activityBasicInfo.setDate(date);
        activityBasicInfo.setTime(date);
//        Community community = new Community();
//        community.setSchool("scdx");
//        community.setSintro("123");
//        community.setSleadername("ymx");
//        community.setSname("sdd");
//        community.setSleaderidcard("123");
//        community.setSleadernum("456");
//        community.setSlevel(0);
//        community.setUserid((long) 1);
//        communityMapper.insert(community);
        for (int i = 0; i < 10; ++i) {
            activityBasicInfoMapper.insert(activityBasicInfo);
        }
        List<ActivityBrief> list = browseService.getActivityListByPage(1, 10);
        System.out.println(JSON.toJSONString(list));
    }


}
