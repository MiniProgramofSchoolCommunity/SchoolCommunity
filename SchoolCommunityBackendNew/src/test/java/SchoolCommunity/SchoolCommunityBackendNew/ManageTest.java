package SchoolCommunity.SchoolCommunityBackendNew;

import SchoolCommunity.SchoolCommunityBackendNew.mappers.ManageMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class ManageTest extends TestClass {

    @Autowired
    private ManageMapper manageMapper;

    @Test
    @Transactional
    @Rollback()
    public void insertIntoManage(){
//        Manage manage;
//        manage.setInterviwee();
//        manage.setManageruserid();
//
//        manageMapper.insert(manage);
    }
}
