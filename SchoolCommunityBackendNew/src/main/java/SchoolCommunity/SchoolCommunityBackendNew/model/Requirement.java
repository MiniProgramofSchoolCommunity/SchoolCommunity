package SchoolCommunity.SchoolCommunityBackendNew.model;

public class Requirement {
    private Long activityid;

    private String requirement;

    private String sname;

    private Integer slevel;

    private String sleadername;

    private String sleadernum;

    private String contactsname;

    private String contactsnum;

    public Long getActivityid() {
        return activityid;
    }

    public void setActivityid(Long activityid) {
        this.activityid = activityid;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Integer getSlevel() {
        return slevel;
    }

    public void setSlevel(Integer slevel) {
        this.slevel = slevel;
    }

    public String getSleadername() {
        return sleadername;
    }

    public void setSleadername(String sleadername) {
        this.sleadername = sleadername == null ? null : sleadername.trim();
    }

    public String getSleadernum() {
        return sleadernum;
    }

    public void setSleadernum(String sleadernum) {
        this.sleadernum = sleadernum == null ? null : sleadernum.trim();
    }

    public String getContactsname() {
        return contactsname;
    }

    public void setContactsname(String contactsname) {
        this.contactsname = contactsname == null ? null : contactsname.trim();
    }

    public String getContactsnum() {
        return contactsnum;
    }

    public void setContactsnum(String contactsnum) {
        this.contactsnum = contactsnum == null ? null : contactsnum.trim();
    }
}