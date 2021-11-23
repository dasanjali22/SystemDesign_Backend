package ie.wellbeing.repository;

import ie.wellbeing.model.LoginUser;
import ie.wellbeing.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDao extends JpaRepository<UserDetails, Integer> {

    UserDetails findByVerificationCode(String verificationCode);
    UserDetails findByEmail(String email);
    LoginUser findByEmailAndConfirmPassword(String email, String confirmPassword);
    UserDetails getUserByEmail(String email);
}
