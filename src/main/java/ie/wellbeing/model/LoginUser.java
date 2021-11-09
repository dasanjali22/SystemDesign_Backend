package ie.wellbeing.model;

import javax.persistence.*;

@Entity
public class LoginUser{

    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName="user_sequence",
            allocationSize=1
    )

    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator="user_sequence"
    )

    private String email;

    @Column(name ="ConfirmPassword")
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

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

//    public UserRole getUserRole() {
//        return userRole;
//    }
//
//    public void setUserRole(UserRole userRole) {
//        this.userRole = userRole;
//    }
//
//    public Boolean getLocked() {
//        return locked;
//    }
//
//    public void setLocked(Boolean locked) {
//        this.locked = locked;
//    }
//
//    public Boolean getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(Boolean enabled) {
//        this.enabled = enabled;
//    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "email='" + email + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", userRole=" + userRole +
                ", locked=" + locked +
                ", enabled=" + enabled +
                '}';
    }
}
