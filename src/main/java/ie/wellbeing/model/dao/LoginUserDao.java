package ie.wellbeing.model.dao;

import ie.wellbeing.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserDao  extends JpaRepository<LoginUser, Long> {
    LoginUser findByEmail(String email);
    LoginUser findByConfirmPassword(String confirmPassword);
//    LoginUser findByUsername(String email);
}
