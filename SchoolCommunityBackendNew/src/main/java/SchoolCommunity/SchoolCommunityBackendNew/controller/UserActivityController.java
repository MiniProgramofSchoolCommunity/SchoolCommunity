package SchoolCommunity.SchoolCommunityBackendNew.controller;

import SchoolCommunity.SchoolCommunityBackendNew.model.ActivityBasicInfo;
import SchoolCommunity.SchoolCommunityBackendNew.services.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/activity/*")
public class UserActivityController {
    @Autowired
    private UserActivityService userActivityService;

    @RequestMapping(value = "/publish.do", method = RequestMethod.POST)
    public String publish(HttpServletRequest request) throws ServletException{
        ActivityBasicInfo activityBasicInfo=new ActivityBasicInfo();

        return "success";
    }
}
