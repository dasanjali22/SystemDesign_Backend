package ie.wellbeing.model;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@Table(name = "userdetails")
public class UserRegistration {

    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName="user_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="user_sequence"
    )

    @Column(name = "UID")
    private Long id;

    @Column(name = "UName")
    private String name;

    @Column(name = "Uemail")
    @Email(message="Please enter a valid email")
    private String email;

    @Column(name = "Uphone")
    private Integer phone;

    @Column(name = "Ucity")
    private String city;

    @Column(name = "Ucountry")
    private String country;

    @Column(name = "Uage")
    private Integer age;

    @Column(name = "UCreatePassword")
    private String CreatePassword;

    @Column(name = "UConfirmPassword")
    private String confirmPassword;

    @Column(name = "membership_name")
    private String mName;


    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    private boolean enabled;

    public UserRegistration() {
    }

    public UserRegistration(String email) {
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreatePassword() {
        return CreatePassword;
    }

    public void setCreatePassword(String createPassword) {
        CreatePassword = createPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

    }
}

