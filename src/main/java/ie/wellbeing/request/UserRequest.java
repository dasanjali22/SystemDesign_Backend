package ie.wellbeing.request;


import javax.validation.constraints.Size;

public class UserRequest {

    private String uName;

    private String uEmail;

    @Size(max = 10)
    private Integer uPhone;

    private String uCity;

    private String uCountry;

    private Integer uAge;

    @Size(max = 8)
    private String uCreatePassword;

    @Size(max = 8)
    private String uConfirmPassword;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public Integer getuPhone() {
        return uPhone;
    }

    public void setuPhone(Integer uPhone) {
        this.uPhone = uPhone;
    }

    public String getuCity() { return uCity; }

    public void setuCity(String uCity) {
        this.uCity = uCity;
    }

    public String getuCountry() {
        return uCountry;
    }

    public void setuCountry(String uCountry) {
        this.uCountry = uCountry;
    }

    public Integer getuAge() {
        return uAge;
    }

    public void setuAge(Integer uAge) {
        this.uAge = uAge;
    }

    public String getuCreatePassword() {
        return uCreatePassword;
    }

    public void setuCreatePassword(String uCreatePassword) {
        this.uCreatePassword = uCreatePassword;
    }

    public String getuConfirmPassword() {
        return uConfirmPassword;
    }

    public void setuConfirmPassword(String uConfirmPassword) {
        this.uConfirmPassword = uConfirmPassword;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "uName='" + uName + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uPhone=" + uPhone + '\'' +
                "uCity='" + uCity + '\'' +
                "uCountry='" + uCountry + '\'' +
                "uAge='" + uAge + '\'' +
                "uCreatePassword='" + uCreatePassword + '\'' +
                "uConfirmPassword='" + uConfirmPassword +
                '}';
    }
}
