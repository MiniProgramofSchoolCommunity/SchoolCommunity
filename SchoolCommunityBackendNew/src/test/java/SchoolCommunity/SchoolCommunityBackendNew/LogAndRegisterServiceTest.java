package SchoolCommunity.SchoolCommunityBackendNew;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Encrypt;
import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.model.Log;
import SchoolCommunity.SchoolCommunityBackendNew.model.UserInfo;
import SchoolCommunity.SchoolCommunityBackendNew.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class LogAndRegisterServiceTest extends TestClass {
    // the class that you want to test
    @Autowired
    private UserService userService;

    @Test
    // 事务管理
    @Transactional
    // 回滚
    @Rollback(false)
    public void register() {
        Log user = new Log();
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail("2");
        userInfo.setRoleid(1);
        user.setUsername("sxx");
        user.setPwd(Encrypt.encrypt("123"));

        Assert.assertSame("error", Status.SUCCESS, userService.reister(user, userInfo));
    }

    @Test
    @Transactional
    public void logIn() {
        Log user = new Log();
        user.setUsername("tyx");
        user.setPwd(Encrypt.encrypt("123"));
        Assert.assertSame("error", Status.SUCCESS, userService.login(user.getUsername(), user.getPwd()));
    }
}
