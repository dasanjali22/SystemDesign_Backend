package ie.wellbeing.request;

public class MembershipRequest {

    private String mName;

    private Long uId;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "MembershipRequest{" +
                "mName='" + mName + '\'' +
                ", uId='" + uId + '\'' +
                '}';
    }
}
