package SchoolCommunity.SchoolCommunityBackendNew.entity;

public enum Status {
    SUCCESS("SUCCESS", 0), FAILED("FAILED", 1), NOTEXISTS("NOTEXISTS", 2), PWDERROR("PWDERROR", 3),
    NOPERMISSION("NOPERMISSION", 4), EXISTED("EXISTED", 5), VERIFIED("VERIFIED", 6), PARAMSERROR("PARAMSERROR", 7);

    private String name;
    private int index;

    private Status(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (Status s : Status.values()) {
            if (s.getIndex() == index) {
                return s.name;
            }
        }
        return null;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
