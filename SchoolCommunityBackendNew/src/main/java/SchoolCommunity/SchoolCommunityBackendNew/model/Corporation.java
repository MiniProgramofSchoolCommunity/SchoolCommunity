package SchoolCommunity.SchoolCommunityBackendNew.model;

public class Corporation {
    private Long userid;

    private String cname;

    private String address;

    private String cintro;

    private String cregisnum;

    private String cleadername;

    private String cleaderidcard;

    private String cleadernum;

    private String contactsname;

    private String contactsnum;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCintro() {
        return cintro;
    }

    public void setCintro(String cintro) {
        this.cintro = cintro == null ? null : cintro.trim();
    }

    public String getCregisnum() {
        return cregisnum;
    }

    public void setCregisnum(String cregisnum) {
        this.cregisnum = cregisnum == null ? null : cregisnum.trim();
    }

    public String getCleadername() {
        return cleadername;
    }

    public void setCleadername(String cleadername) {
        this.cleadername = cleadername == null ? null : cleadername.trim();
    }

    public String getCleaderidcard() {
        return cleaderidcard;
    }

    public void setCleaderidcard(String cleaderidcard) {
        this.cleaderidcard = cleaderidcard == null ? null : cleaderidcard.trim();
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