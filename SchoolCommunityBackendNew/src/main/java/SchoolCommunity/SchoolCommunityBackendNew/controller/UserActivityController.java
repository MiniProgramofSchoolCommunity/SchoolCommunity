package SchoolCommunity.SchoolCommunityBackendNew.controller;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityBasicInfo;
import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityNeeded;
import SchoolCommunity.SchoolCommunityBackendNew.model.Requirement;
import SchoolCommunity.SchoolCommunityBackendNew.services.UserActivityService;
import SchoolCommunity.SchoolCommunityBackendNew.services.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user/activity/*")
@EnableTransactionManagement
public class UserActivityController {
    @Autowired
    private UserActivityService userActivityService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/publish.do", method = RequestMethod.POST)
    @ResponseBody
    public String publish(@RequestBody JSONObject jsonParams) throws ServletException {
        Map<String, String> resultStatus = new HashMap<>();
        Long id = jsonParams.getLong("userid");
        if (id == null) {
            resultStatus.put("STATUS", Status.PARAMSERROR.getName());
            return JSON.toJSONString(resultStatus);
        }
        Status verifiedStatus = userService.isVerified(id);
        if (verifiedStatus == Status.NOPERMISSION) {
            resultStatus.put("STATUS", Status.NOPERMISSION.getName());
            return JSON.toJSONString(resultStatus);
        } else if (verifiedStatus == Status.PARAMSERROR) {
            resultStatus.put("STATUS", Status.PARAMSERROR.getName());
            return JSON.toJSONString(resultStatus);
        }
        ActivityBasicInfo activityBasicInfo = new ActivityBasicInfo();
        activityBasicInfo.setActivityname(jsonParams.getString("activityName"));
        activityBasicInfo.setActivityaddress(jsonParams.getString("activityAddress"));
        activityBasicInfo.setPublisherid(id);
        activityBasicInfo.setActivityintro(jsonParams.getString("activityIntro"));
        // fixme 时间
        activityBasicInfo.setDate(new Date());
        activityBasicInfo.setTime(new Date());
        if (activityBasicInfo.getActivityname() == null || activityBasicInfo.getActivityaddress() == null
                || activityBasicInfo.getActivityintro() == null || activityBasicInfo.getDate() == null
                || activityBasicInfo.getTime() == null) {
            resultStatus.put("STATUS", Status.PARAMSERROR.getName());
        } else {
            int type = jsonParams.getInteger("activityType");
            if (type == 0) {
                activityBasicInfo.setType(0);
                Requirement requirement = new Requirement();
                requirement.setRequirement(jsonParams.getString("requirement"));
                Status serviceStatus = userActivityService.publish(activityBasicInfo, requirement);
                if (serviceStatus != Status.SUCCESS) {
                    resultStatus.put("STATUS", Status.FAILED.getName());
                } else {
                    resultStatus.put("STATUS", Status.SUCCESS.getName());
                }
            } else if (type == 1) {
                activityBasicInfo.setType(1);
                ActivityNeeded activityNeeded = new ActivityNeeded();
                activityNeeded.setRequirement(jsonParams.getString("requirement"));
                activityNeeded.setSponsorship(jsonParams.getString("sponsorship"));
                Status serveiceStatus = userActivityService.publish(activityBasicInfo, activityNeeded);
                if (serveiceStatus != Status.SUCCESS) {
                    resultStatus.put("STATUS", Status.FAILED.getName());
                } else {
                    resultStatus.put("STATUS", Status.SUCCESS.getName());
                }
            } else {
                resultStatus.put("STATUS", Status.PARAMSERROR.getName());
            }
        }
        return JSON.toJSONString(resultStatus);
    }

}
