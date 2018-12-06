package SchoolCommunity.SchoolCommunityBackendNew.controller;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Encrypt;
import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.model.Community;
import SchoolCommunity.SchoolCommunityBackendNew.model.Corporation;
import SchoolCommunity.SchoolCommunityBackendNew.model.Log;
import SchoolCommunity.SchoolCommunityBackendNew.model.UserInfo;
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
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

// 开启事务管理
@EnableTransactionManagement
@Controller
@RequestMapping("/user/*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request) throws ServletException {
        Log userLogInfo = new Log();
        Map<String, String> logInStatus;
        Status userServiceStatus;
        userLogInfo.setUsername(request.getParameter("username"));

        // encryt  the pwd using java MessageDigest
        String rawPwd = request.getParameter("pwd");
        String pwd = Encrypt.encrypt(rawPwd);
        userLogInfo.setPwd(pwd);

        System.out.println(request.getHeader("Content-Type"));
        // fixme 修改后台加密为数据库加密
        if (userLogInfo.getPwd() != null && userLogInfo.getUsername() != null) {
            logInStatus = userService.login(userLogInfo.getUsername(), userLogInfo.getPwd());
        } else {
            System.out.println(userLogInfo.getUsername() + " " + userLogInfo.getPwd());
            logInStatus = new HashMap<>();
            logInStatus.put("STATUS", Status.FAILED.getName());
            logInStatus.put("TYPE", null);
            logInStatus.put("USERID", null);
        }
        // todo 使用小程序接口来验证cookie
//                String cookieString = Encrypt.encrypt(userLogInfo.getUsername() + String.valueOf(System.nanoTime()));
//                Cookie cookie = new Cookie("user", cookieString);
//                cookie.setMaxAge(3600);
//                response.addCookie(cookie);
        return JSON.toJSONString(logInStatus);
    }

    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request) throws ServletException {
        Log userRegisterLog = new Log();
        Status registerStatus;
        userRegisterLog.setUsername(request.getParameter("username"));
        String rawpwd = request.getParameter("pwd");
        String pwd = Encrypt.encrypt(rawpwd);
        userRegisterLog.setPwd(pwd);
        UserInfo userRegisterUserInfo = new UserInfo();
        userRegisterUserInfo.setEmail(request.getParameter("email"));
        Integer type = Integer.valueOf(request.getParameter("itype"));
        userRegisterUserInfo.setRoleid(type);

        // todo 验证email合法性
        if (userRegisterLog.getUsername() != null && userRegisterLog.getPwd() != null
                && userRegisterUserInfo.getEmail() != null
                && (userRegisterUserInfo.getRoleid() != 3 || userRegisterUserInfo.getRoleid() != 2)) {
            registerStatus = userService.reister(userRegisterLog, userRegisterUserInfo);
        } else {
            registerStatus = Status.FAILED;
        }

        switch (registerStatus) {
            case SUCCESS:
                return "success";
            case EXISTED:
                return "existed";
            default:
                return "failed";
        }
    }

    @RequestMapping(value = "/verifyStatus.do", method = RequestMethod.GET)
    @ResponseBody
    public String verifyStatus(@RequestBody JSONObject jsonParams) throws ServletException {
        Map<String, String> resultStatus = new HashMap<>();
        Long id = jsonParams.getLong("userid");
        if (id == null) {
            resultStatus.put("STATUS", Status.PARAMSERROR.getName());
        } else {
            Status verifiedStatus = userService.isVerified(id);
            if (verifiedStatus == Status.NOPERMISSION) {
                resultStatus.put("STATUS", Status.NOPERMISSION.getName());
            } else {
                resultStatus.put("STATUS", Status.SUCCESS.getName());
            }
        }
        return JSONObject.toJSONString(resultStatus);
    }

    // todo 审核请求处理
    @RequestMapping(value = "/verifyRequest.do", method = RequestMethod.POST)
    @ResponseBody
    public String verifyRequest(@RequestBody JSONObject jsonParams) throws ServletException {
        int type = jsonParams.getInteger("type");
        Map<String, String> resultStatus = new HashMap<>();
        if (type == 2) {
            Community community = new Community();
            community.setUserid(jsonParams.getLong("userid"));
            community.setSlevel(jsonParams.getInteger("level"));
            community.setSleadernum(jsonParams.getString("leadernum"));
            community.setSleaderidcard(jsonParams.getString("leaderidcard"));
            community.setSname(jsonParams.getString("sname"));
            community.setSleadername(jsonParams.getString("leadername"));
            community.setSintro(jsonParams.getString("sintro"));
            community.setSchool(jsonParams.getString("school"));
            community.setContactsname(jsonParams.getString("contactsname"));
            community.setContactsnum(jsonParams.getString("contactsnum"));
            if (community.getSname() == null || community.getSchool() == null || community.getSintro() == null
                    || community.getSleaderidcard() == null || community.getSleadername() == null ||
                    community.getSleadernum() == null || community.getSlevel() == null || community.getUserid() == null) {
                resultStatus.put("STATUS", Status.PARAMSERROR.getName());
            } else {
                Status userServiecStatus = userService.verifyRequest(community.getUserid(), community);
                switch (userServiecStatus) {
                    case NOTEXISTS:
                        resultStatus.put("STATUS", Status.NOTEXISTS.getName());
                        break;
                    case SUCCESS:
                        resultStatus.put("STATUS", Status.SUCCESS.getName());
                        break;
                    case FAILED:
                        resultStatus.put("STATUS", Status.FAILED.getName());
                }
            }
        } else if (type == 3) {
            Corporation corporation = new Corporation();
            corporation.setAddress(jsonParams.getString("address"));
            corporation.setCintro(jsonParams.getString("cintro"));
            corporation.setCleaderidcard(jsonParams.getString("leaderidcard"));
            corporation.setCleadername(jsonParams.getString("leadername"));
            corporation.setCleadernum(jsonParams.getString("leadernum"));
            corporation.setCname(jsonParams.getString("cname"));
            corporation.setCregisnum(jsonParams.getString("regisnum"));
            corporation.setUserid(jsonParams.getLong("userid"));
            corporation.setContactsname(jsonParams.getString("contactsname"));
            corporation.setContactsnum(jsonParams.getString("contactsnum"));
            if (corporation.getAddress() == null || corporation.getCintro() == null
                    || corporation.getCleaderidcard() == null || corporation.getCleadername() == null
                    || corporation.getCleadernum() == null || corporation.getCname() == null
                    || corporation.getCregisnum() == null || corporation.getUserid() == null) {
                resultStatus.put("STATUS", Status.PARAMSERROR.getName());
            } else {
                Status userServiceStatus = userService.verifyRequest(corporation.getUserid(), corporation);
                switch (userServiceStatus) {
                    case FAILED:
                        resultStatus.put("STATUS", Status.FAILED.getName());
                        break;
                    case NOTEXISTS:
                        resultStatus.put("STATUS", Status.NOTEXISTS.getName());
                        break;
                    case SUCCESS:
                        resultStatus.put("STATUS", Status.SUCCESS.getName());
                }
            }
        } else {
            resultStatus.put("STATUS", Status.PARAMSERROR.getName());
        }

        return JSON.toJSONString(resultStatus);
    }
}
