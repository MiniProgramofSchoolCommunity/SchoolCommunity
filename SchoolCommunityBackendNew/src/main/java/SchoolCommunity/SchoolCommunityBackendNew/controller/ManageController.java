package SchoolCommunity.SchoolCommunityBackendNew.controller;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.model.Community;
import SchoolCommunity.SchoolCommunityBackendNew.model.Corporation;
import SchoolCommunity.SchoolCommunityBackendNew.services.ManageService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableTransactionManagement
@RequestMapping("/manage/*")
public class ManageController {

    @Autowired
    private ManageService manageService;

    @RequestMapping(value = "/getRequestInfo.do", method = RequestMethod.GET)
    @ResponseBody
    public String getRequestInfo(@RequestBody JSONObject jsonParams) throws ServletException {
        Map<String, String> resultStatus = new HashMap<>();
        int type = jsonParams.getInteger("type");
        long userid = jsonParams.getLong("userid");
        if (type == 1) {
            List<Community> communityList = manageService.getCommunityRequestInfo(userid, type);
            if (communityList == null) {
                resultStatus.put("STATUS", Status.PARAMSERROR.getName());
                return JSON.toJSONString(resultStatus);
            } else {
                return JSON.toJSONString(communityList);
            }
        } else if (type == 0) {
            List<Corporation> corporationList = manageService.getCorporationRequestInfo(userid, type);
            if (corporationList == null) {
                resultStatus.put("STATUS", Status.PARAMSERROR.getName());
                return JSON.toJSONString(resultStatus);
            } else {
                return JSON.toJSONString(corporationList);
            }
        } else {
            resultStatus.put("STATUS", Status.PARAMSERROR.getName());
        }
        return JSON.toJSONString(resultStatus);
    }

    @RequestMapping(value = "/verify.do", method = RequestMethod.POST)
    @ResponseBody
    public String verify(@RequestBody JSONObject jsonParams) throws ServletException {
        Map<String, String> resultStatus = new HashMap<>();
        int managerid = jsonParams.getInteger("manager");
        int interviewee = jsonParams.getInteger("interviewee");
        Status serviecStatus = manageService.verify(managerid, interviewee);
        switch (serviecStatus) {
            case SUCCESS:
                resultStatus.put("STATUS", Status.SUCCESS.getName());
                break;
            case FAILED:
                resultStatus.put("STATUS", Status.FAILED.getName());
                break;
            case NOPERMISSION:
                resultStatus.put("STATUS", Status.NOPERMISSION.getName());
                break;
            case VERIFIED:
                resultStatus.put("STATUS", Status.VERIFIED.getName());
                break;
            case NOTEXISTS:
                resultStatus.put("STATUS", Status.NOTEXISTS.getName());
        }
        return JSON.toJSONString(resultStatus);
    }

    @RequestMapping(value = "/cancelVerify.do", method = RequestMethod.POST)
    @ResponseBody
    public String cancelVerify(@RequestBody JSONObject jsonParams) throws ServletException {
        Map<String, String> resultStatus = new HashMap<>();
        int managerid = jsonParams.getInteger("manager");
        int interviewee = jsonParams.getInteger("interviewee");
        Status serviceStatus = manageService.cancleVerify(managerid, interviewee);
        switch (serviceStatus) {
            case SUCCESS:
                resultStatus.put("STATUS", Status.SUCCESS.getName());
                break;
            case NOTEXISTS:
                resultStatus.put("STATUS", Status.NOTEXISTS.getName());
                break;
            case NOPERMISSION:
                resultStatus.put("STATUS", Status.NOPERMISSION.getName());
                break;
            case FAILED:
                resultStatus.put("STATUS", Status.FAILED.getName());
        }
        return JSON.toJSONString(resultStatus);
    }
}
