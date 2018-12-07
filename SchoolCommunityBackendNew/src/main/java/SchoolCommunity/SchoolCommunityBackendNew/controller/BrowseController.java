package SchoolCommunity.SchoolCommunityBackendNew.controller;

import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityBrief;
import SchoolCommunity.SchoolCommunityBackendNew.entity.ActivityDetail;
import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.services.BrowseService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/activity/*")
public class BrowseController {

    @Autowired
    private BrowseService browseService;

    // todo 获取活动简略信息处理
    @RequestMapping(value = "/getActivityList.do", method = RequestMethod.POST)
    @ResponseBody
    public String getActivityList(@RequestBody JSONObject jsonParams) throws ServletException {
        int pageNum = jsonParams.getInteger("pageNum");
        int pageSize = 10;
        ArrayList<ActivityBrief> activityBriefArrayList = browseService.getActivityListByPage(pageNum, pageSize);

        return JSON.toJSONString(activityBriefArrayList);
    }

    @RequestMapping(value = "/getPageInfo.do", method = RequestMethod.POST)
    @ResponseBody
    public String getPageInfo(@RequestBody JSONObject jsonParams) throws ServletException {
        int pageNum = jsonParams.getInteger("pageNum");
        int pageSize = 10;
        PageInfo<ActivityBrief> briefPageInfo = browseService.getPageInfo(pageNum, pageSize);
        return JSON.toJSONString(briefPageInfo);
    }

    // todo 活动详细信息请求
    @RequestMapping(value = "/getActivityDetail.do", method = RequestMethod.POST)
    @ResponseBody
    public String getActivityDetail(@RequestBody JSONObject jsonParams) {
        Map<String, String> resultStatus = new HashMap<>();
        long id = jsonParams.getLong("activityId");
        int type = jsonParams.getInteger("atype");
        ActivityDetail activityDetail = browseService.getActivityDetail(id, type);
        if (activityDetail == null) {
            resultStatus.put("STATUS", Status.PARAMSERROR.getName());
            return JSON.toJSONString(resultStatus);
        }
        return JSON.toJSONString(activityDetail);
    }
}
