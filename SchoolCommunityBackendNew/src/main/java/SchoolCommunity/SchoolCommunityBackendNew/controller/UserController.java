package SchoolCommunity.SchoolCommunityBackendNew.controller;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Encrypt;
import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.model.Log;
import SchoolCommunity.SchoolCommunityBackendNew.model.UserInfo;
import SchoolCommunity.SchoolCommunityBackendNew.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 开启事务管理
@EnableTransactionManagement
@Controller
@RequestMapping("/user/*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Log userLogInfo = new Log();
        String logInStatus;
        userLogInfo.setUsername(request.getParameter("username"));

        // encryt  the pwd using java MessageDigest
        String rawPwd = request.getParameter("pwd");
        String pwd = Encrypt.encrypt(rawPwd);
        userLogInfo.setPwd(pwd);

        System.out.println(request.getHeader("Content-Type"));
        // todo encrypt the pwd through the database or the spring?
        // fixme 修改后台加密为数据库加密
        // todo 返回用户id
        if (userLogInfo.getPwd() != null && userLogInfo.getUsername() != null) {
            logInStatus = userService.login(userLogInfo.getUsername(), userLogInfo.getPwd());
            System.out.println(logInStatus);
        } else {
            System.out.println(userLogInfo.getUsername() + " " + userLogInfo.getPwd());
            logInStatus = Status.FAILED;
        }
        switch (logInStatus) {
            case SUCCESS:
                // fixme 使用小程序接口来验证cookie
//                String cookieString = Encrypt.encrypt(userLogInfo.getUsername() + String.valueOf(System.nanoTime()));
//                Cookie cookie = new Cookie("user", cookieString);
//                cookie.setMaxAge(3600);
//                response.addCookie(cookie);
                return "success";
            case NOTEXISTS:
                return "notexits";
            case PWDERROR:
                return "pwderror";
            default:
                return "failed";
        }
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

    // todo 活动详细信息请求

    // todo 审核请求处理
    @RequestMapping(value = "/verifyRequest.do", method = RequestMethod.POST)
    @ResponseBody
    public String verifyRequest(HttpServletRequest request) throws ServletException {


        return "success";
    }
}
