package SchoolCommunity.SchoolCommunityBackendNew.model;

public class ActivityNeeded {
    private Long activityid;

    private String cname;

    private String requirement;

    private String sponsorship;

    private String cleadername;

    private String cleadernum;

    private String contactsname;

    private String contactsnum;

    public Long getActivityid() {
        return activityid;
    }

    public void setActivityid(Long activityid) {
        this.activityid = activityid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public String getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(String sponsorship) {
        this.sponsorship = sponsorship == null ? null : sponsorship.trim();
    }

    public String getCleadername() {
        return cleadername;
    }

    public void setCleadername(String cleadername) {
        this.cleadername = cleadername == null ? null : cleadername.trim();
    }

    public String getCleadernum() {
        return cleadernum;
    }

    public void setCleadernum(String cleadernum) {
        this.cleadernum = cleadernum == null ? null : cleadernum.trim();
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