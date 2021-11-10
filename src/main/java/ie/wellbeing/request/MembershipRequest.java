package ie.wellbeing.request;

public class MembershipRequest {

    private String mName;

    private Integer uId;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
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
