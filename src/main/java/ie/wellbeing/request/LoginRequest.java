package ie.wellbeing.request;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class LoginRequest  implements Serializable {

    private static final long serialVersionUID = -5616176897013108345L;
    private String uEmail;
    @Size(max = 8)
    private String uConfirmPassword;

    public LoginRequest() {
    }

    public LoginRequest(String uEmail, String uConfirmPassword) {
        this.uEmail = uEmail;
        this.uConfirmPassword = uConfirmPassword;
    }

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
