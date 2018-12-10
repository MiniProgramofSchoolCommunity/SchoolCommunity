package SchoolCommunity.SchoolCommunityBackendNew.services.serviceImpl;

import SchoolCommunity.SchoolCommunityBackendNew.entity.Status;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.CommunityMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.CorporationMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.ManageMapper;
import SchoolCommunity.SchoolCommunityBackendNew.mappers.UserInfoMapper;
import SchoolCommunity.SchoolCommunityBackendNew.model.*;
import SchoolCommunity.SchoolCommunityBackendNew.services.ManageService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("ManageService")
@Transactional
public class ManageServiceImpl implements ManageService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private CorporationMapper corporationMapper;

    @Autowired
    private ManageMapper manageMapper;

    @Override
    public PageInfo<Community> getCommunityRequestInfo(long userid, int type, int pageNum) {
        PageInfo<Community> communityPageInfo;
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userid);
        int userType = userInfo.getRoleid();
        if (userType != type || type != 1) {
            communityPageInfo = null;
        } else {
            ManageExample manageExample = new ManageExample();
            ManageExample.Criteria manageCriteria = manageExample.createCriteria();
            manageCriteria.andManageruseridEqualTo(userid);

            List<Manage> manageList = manageMapper.selectByExample(manageExample);
            if (!manageList.isEmpty()) {
                CommunityExample communityExample = new CommunityExample();
                CommunityExample.Criteria communityCriteria = communityExample.createCriteria();
                ArrayList<Long> useridList = new ArrayList<>();
                for (Manage manager : manageList) {
                    useridList.add(manager.getInterviwee());
                }

                UserInfoExample userInfoExample = new UserInfoExample();
                UserInfoExample.Criteria userInfoCriteria = userInfoExample.createCriteria();
                userInfoCriteria.andUseridIn(useridList);

                PageHelper.startPage(pageNum, 10);
                List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
                PageInfo<UserInfo> userInfoPageInfo = new PageInfo<>(userInfoList);
                if (!useridList.isEmpty()) {
                    useridList.clear();
                    for (UserInfo user : userInfoList) {
                        if (user.getSent() == 1) {
                            useridList.add(user.getUserid());
                        }
                    }
                    communityCriteria.andUseridIn(useridList);

                    List<Community> communityList = communityMapper.selectByExample(communityExample);
                    communityPageInfo = new PageInfo<>(communityList);
                    communityPageInfo.setEndRow(userInfoPageInfo.getEndRow());
                    communityPageInfo.setHasNextPage(userInfoPageInfo.isHasNextPage());
                    communityPageInfo.setHasPreviousPage(userInfoPageInfo.isHasPreviousPage());
                    communityPageInfo.setIsFirstPage(userInfoPageInfo.isIsFirstPage());
                    communityPageInfo.setIsLastPage(userInfoPageInfo.isIsLastPage());
                    communityPageInfo.setNavigateFirstPage(userInfoPageInfo.getNavigateFirstPage());
                    communityPageInfo.setNavigateLastPage(userInfoPageInfo.getNavigateLastPage());
                    communityPageInfo.setNavigatePages(userInfoPageInfo.getNavigatePages());
                    communityPageInfo.setNavigatepageNums(userInfoPageInfo.getNavigatepageNums());
                    communityPageInfo.setNextPage(userInfoPageInfo.getNextPage());
                    communityPageInfo.setPageNum(userInfoPageInfo.getPageNum());
                    communityPageInfo.setPageSize(userInfoPageInfo.getPageSize());
                    communityPageInfo.setPages(userInfoPageInfo.getPages());
                    communityPageInfo.setPrePage(userInfoPageInfo.getPrePage());
                    communityPageInfo.setSize(userInfoPageInfo.getSize());
                    communityPageInfo.setStartRow(userInfoPageInfo.getStartRow());
                    communityPageInfo.setTotal(userInfoPageInfo.getTotal());
                } else {
                    communityPageInfo = null;
                }
            } else {
                communityPageInfo = null;
            }
        }

        return communityPageInfo;
    }

    @Override
    public PageInfo<Corporation> getCorporationRequestInfo(long userid, int type, int pageNum) {
        PageInfo<Corporation> corporationPageInfo;
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userid);
        int userType = userInfo.getRoleid();
        if (userType != type || type != 0) {
            corporationPageInfo = null;
        } else {
            ManageExample manageExample = new ManageExample();
            ManageExample.Criteria mangeCriteria = manageExample.createCriteria();
            mangeCriteria.andManageruseridEqualTo(userid);

            List<Manage> mangeList = manageMapper.selectByExample(manageExample);
            if (!mangeList.isEmpty()) {
                CorporationExample corporationExample = new CorporationExample();
                CorporationExample.Criteria corporationCriteria = corporationExample.createCriteria();
                ArrayList<Long> useridList = new ArrayList<>();
                for (Manage manager : mangeList) {
                    useridList.add(manager.getInterviwee());
                }
                UserInfoExample userInfoExample = new UserInfoExample();
                UserInfoExample.Criteria userInfoCriteria = userInfoExample.createCriteria();
                userInfoCriteria.andUseridIn(useridList);
                PageHelper.startPage(pageNum, 10);
                List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
                PageInfo<UserInfo> userInfoPageInfo = new PageInfo<>(userInfoList);
                if (!useridList.isEmpty()) {
                    useridList.clear();
                    for (UserInfo user : userInfoList) {
                        if (user.getSent() == 1) {
                            useridList.add(user.getUserid());
                        }
                    }
                    corporationCriteria.andUseridIn(useridList);
                    List<Corporation> corporationList = corporationMapper.selectByExample(corporationExample);
                    corporationPageInfo = new PageInfo<>(corporationList);
                    System.out.println(JSON.toJSONString(corporationPageInfo));
                    corporationPageInfo.setEndRow(userInfoPageInfo.getEndRow());
                    corporationPageInfo.setHasNextPage(userInfoPageInfo.isHasNextPage());
                    corporationPageInfo.setHasPreviousPage(userInfoPageInfo.isHasPreviousPage());
                    corporationPageInfo.setIsFirstPage(userInfoPageInfo.isIsFirstPage());
                    corporationPageInfo.setIsLastPage(userInfoPageInfo.isIsLastPage());
                    corporationPageInfo.setNavigateFirstPage(userInfoPageInfo.getNavigateFirstPage());
                    corporationPageInfo.setNavigateLastPage(userInfoPageInfo.getNavigateLastPage());
                    corporationPageInfo.setNavigatePages(userInfoPageInfo.getNavigatePages());
                    corporationPageInfo.setNavigatepageNums(userInfoPageInfo.getNavigatepageNums());
                    corporationPageInfo.setNextPage(userInfoPageInfo.getNextPage());
                    corporationPageInfo.setPageNum(userInfoPageInfo.getPageNum());
                    corporationPageInfo.setPageSize(userInfoPageInfo.getPageSize());
                    corporationPageInfo.setPages(userInfoPageInfo.getPages());
                    corporationPageInfo.setPrePage(userInfoPageInfo.getPrePage());
                    corporationPageInfo.setSize(userInfoPageInfo.getSize());
                    corporationPageInfo.setStartRow(userInfoPageInfo.getStartRow());
                    corporationPageInfo.setTotal(userInfoPageInfo.getTotal());
                } else {
                    corporationPageInfo = null;
                }
            } else {
                corporationPageInfo = null;
            }
        }
        return corporationPageInfo;
    }

    @Override
    public Status verify(long managerid, long userid) {
        Status status;
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(managerid);
        if (userInfo != null && (userInfo.getRoleid() == 0 || userInfo.getRoleid() == 1)) {
            UserInfo interviewee = userInfoMapper.selectByPrimaryKey(userid);
            if (interviewee == null || interviewee.getSent() == 0) {
                status = Status.NOTEXISTS;
            } else if (interviewee.getStatus() == 1) {
                status = Status.VERIFIED;
            } else {
                interviewee.setStatus(1);
                int row = userInfoMapper.updateByPrimaryKeySelective(interviewee);
                if (row != 1) {
                    status = Status.FAILED;
                } else {
                    status = Status.SUCCESS;
                }
            }
        } else {
            status = Status.NOPERMISSION;
        }
        return status;
    }

    @Override
    public Status cancleVerify(long managerid, long userid) {
        Status status;
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(managerid);
        if (userInfo == null || userInfo.getRoleid() != 1 || userInfo.getRoleid() != 0) {
            status = Status.NOPERMISSION;
        } else {
            UserInfo interviewee = userInfoMapper.selectByPrimaryKey(userid);
            if (interviewee == null || interviewee.getSent() == 0) {
                status = Status.NOTEXISTS;
            } else {
                interviewee.setStatus(0);
                int row = userInfoMapper.updateByPrimaryKeySelective(interviewee);
                if (row != 1) {
                    status = Status.FAILED;
                } else {
                    status = Status.SUCCESS;
                }
            }
        }
        return status;
    }
}
