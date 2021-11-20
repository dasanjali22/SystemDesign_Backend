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
    @SequenceGenerator(
            name="user_sequence",
            sequenceName="user_sequence",
            allocationSize=1
    )

    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="user_sequence"
    )

    private String email;
    private String name;
    @Column(name ="ConfirmPassword")
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<UserRole> roles = new ArrayList<>();

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


//    @Override
//    public String toString() {
//        return "LoginUser{" +
//                "email='" + email + '\'' +
//                ", confirmPassword='" + confirmPassword + '\'' +
//                ", userRole=" + userRole +
//                ", locked=" + locked +
//                ", enabled=" + enabled +
//                '}';
//    }
}
