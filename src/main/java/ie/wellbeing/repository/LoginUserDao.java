package ie.wellbeing.repository;

import ie.wellbeing.model.LoginUser;
import ie.wellbeing.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserDao  extends JpaRepository<LoginUser, Long> {
    LoginUser findByEmail(String email);
//    LoginUser getUserByEmail(String email);
}
