package SchoolCommunity.SchoolCommunityBackendNew.model;

public class Community {
    private Long userid;

    private String sname;

    private String school;

    private Integer slevel;

    private String sintro;

    private String sleadername;

    private String sleaderidcard;

    private String sleadernum;

    private String contactsname;

    private String contactsnum;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Integer getSlevel() {
        return slevel;
    }

    public void setSlevel(Integer slevel) {
        this.slevel = slevel;
    }

    public String getSintro() {
        return sintro;
    }

    public void setSintro(String sintro) {
        this.sintro = sintro == null ? null : sintro.trim();
    }

    public String getSleadername() {
        return sleadername;
    }

    public void setSleadername(String sleadername) {
        this.sleadername = sleadername == null ? null : sleadername.trim();
    }

    public String getSleaderidcard() {
        return sleaderidcard;
    }

    public void setSleaderidcard(String sleaderidcard) {
        this.sleaderidcard = sleaderidcard == null ? null : sleaderidcard.trim();
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