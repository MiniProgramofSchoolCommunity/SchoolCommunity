package SchoolCommunity.SchoolCommunityBackendNew.controller;

import SchoolCommunity.SchoolCommunityBackendNew.services.ManageService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableTransactionManagement
@RequestMapping("/manage/*")
public class ManageController {

    @Autowired
    private ManageService manageService;

    @RequestMapping(value = "/getRequestInfo.do",method = RequestMethod.GET)
    @ResponseBody
    public String getRequestInfo(@RequestBody JSONObject jsonParams){
        int type = jsonParams.getInteger("type");
        long userid = jsonParams.getLong("userid");
        return "error";
    }
}
