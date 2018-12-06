package SchoolCommunity.SchoolCommunityBackendNew.controller;

import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityBrief;
import SchoolCommunity.SchoolCommunityBackendNew.services.BrowseService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/activity/*")
public class BrowseController {

    @Autowired
    private BrowseService browseService;

    // todo 获取活动简略信息
    @RequestMapping(value = "/getActivityList.do", method = RequestMethod.GET)
    @ResponseBody
    public String getActivityList(HttpServletRequest request) throws ServletException {
        int pageNum = Integer.valueOf(request.getParameter("pageNum"));
        int pageSize = 10;
        ArrayList<ActivityBrief> activityBriefArrayList = browseService.getActivityListByPage(pageNum, pageSize);

        return JSON.toJSONString(activityBriefArrayList);
    }

    @RequestMapping(value = "/getPageInfo.do", method = RequestMethod.GET)
    @ResponseBody
    public String getPageInfo(HttpServletRequest request) throws ServletException {
        int pageNum = Integer.valueOf(request.getParameter("pageNum"));
        int pageSize = 10;
        PageInfo<ActivityBrief> briefPageInfo = browseService.getPageInfo(pageNum, pageSize);
        return JSON.toJSONString(briefPageInfo);
    }
}
