package ie.wellbeing.DTO;

import javax.validation.constraints.Size;

public class LoginRequestDto {
    private String uEmail;
    @Size(max = 8)
    private String uConfirmPassword;

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
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
                ", uEmail='" + uEmail + '\'' +
                "uConfirmPassword='" + uConfirmPassword +
                '}';
    }
}
