package ie.wellbeing.DTO;

public class RoleRequestDto {

    private String uRole;
    private Integer uId;

    public String getuRole() {
        return uRole;
    }

    public void setuRole(String uRole) {
        this.uRole = uRole;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "RoleRequest{" +
                "uRole='" + uRole + '\'' +
                ", uId=" + uId +
                '}';
    }
}