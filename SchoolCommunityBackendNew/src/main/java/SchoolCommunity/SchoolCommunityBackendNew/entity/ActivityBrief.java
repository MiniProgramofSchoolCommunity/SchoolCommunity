package SchoolCommunity.SchoolCommunityBackendNew.entity;

import java.util.Date;

public class ActivityBrief {

    /**
     * 活动类型
     * 活动名称
     * 时间
     * 地点
     * 主办方
     * 等级
     * id
     */
    private int type;
    private String activityName;
    private Date date;
    private String address;
    private String sponsorName;
    private int sLevel;
    private Long id;

    public void setType(int type) {
        this.type = type;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setsLevel(int sLevel) {
        this.sLevel = sLevel;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public int getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getsLevel() {
        return sLevel;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getAddress() {
        return address;
    }

    public String getSponsorName() {
        return sponsorName;
    }
}
