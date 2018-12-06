package SchoolCommunity.SchoolCommunityBackendNew.entity;

import java.util.Date;

public class ActivityDetail {
    /**
     * 赞助详情
     * id->detail:(
     * id,活动类型
     * 活动名称
     * 时间
     * 地点
     * 主办方
     * 等级,
     * 赞助需求，活动介绍，负责人姓名，社团名称，负责人联系方式，活动联系人姓名，活动联系人联系方式)
     * id->detail:(
     * id,活动类型
     * 活动名称
     * 时间
     * 地点
     * 主办方
     * 活动要求，赞助介绍，活动介绍，公司名称，负责人姓名，负责人联系方式，活动联系人姓名，活动联系人联系方式)
     */

    private long activityId;
    private int type;
    private String activityName;
    private String activityAddress;
    private Date date;
    private Date time;
    private String sponsor;
    private String requirementOfActivity;
    private String activityIntro;
    private String leaderName;
    private String leaderNum;
    private String requirementOfSponsorship;
    private int level;
    private String sponsorshipIntro;
    private String contactsName;
    private String contactsNum;

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public Date getTime() {
        return time;
    }

    public int getLevel() {
        return level;
    }

    public long getActivityId() {
        return activityId;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public String getActivityIntro() {
        return activityIntro;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getContactsName() {
        return contactsName;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public String getContactsNum() {
        return contactsNum;
    }

    public String getLeaderNum() {
        return leaderNum;
    }

    public String getRequirementOfActivity() {
        return requirementOfActivity;
    }

    public String getRequirementOfSponsorship() {
        return requirementOfSponsorship;
    }

    public String getSponsor() {
        return sponsor;
    }

    public String getSponsorshipIntro() {
        return sponsorshipIntro;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public void setActivityIntro(String activityIntro) {
        this.activityIntro = activityIntro;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public void setContactsNum(String contactsNum) {
        this.contactsNum = contactsNum;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public void setLeaderNum(String leaderNum) {
        this.leaderNum = leaderNum;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setRequirementOfActivity(String requirementOfActivity) {
        this.requirementOfActivity = requirementOfActivity;
    }

    public void setRequirementOfSponsorship(String requirementOfSponsorship) {
        this.requirementOfSponsorship = requirementOfSponsorship;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public void setSponsorshipIntro(String sponsorshipIntro) {
        this.sponsorshipIntro = sponsorshipIntro;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
