package ie.wellbeing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class LoginUser{

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="user_sequence"
    )

    private String email;
    private String name;
    @Column(name ="ConfirmPassword")
    private String confirmPassword;


    private Boolean locked = false;

    private Boolean enabled = false;

    public LoginUser( String email,
                     String ConfirmPassword){

        this.email = email;
        this.confirmPassword = ConfirmPassword;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
