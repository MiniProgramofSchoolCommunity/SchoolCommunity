package SchoolCommunity.SchoolCommunityBackendNew.model;

import java.util.Date;

public class ActivityBasicInfo {
    private Long activityid;

    private Long publisherid;

    private String activityname;

    private String activityaddress;

    private Date date;

    private Date time;

    private String activityintro;

    private Integer type;

    public Long getActivityid() {
        return activityid;
    }

    public void setActivityid(Long activityid) {
        this.activityid = activityid;
    }

    public Long getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Long publisherid) {
        this.publisherid = publisherid;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname == null ? null : activityname.trim();
    }

    public String getActivityaddress() {
        return activityaddress;
    }

    public void setActivityaddress(String activityaddress) {
        this.activityaddress = activityaddress == null ? null : activityaddress.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getActivityintro() {
        return activityintro;
    }

    public void setActivityintro(String activityintro) {
        this.activityintro = activityintro == null ? null : activityintro.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}