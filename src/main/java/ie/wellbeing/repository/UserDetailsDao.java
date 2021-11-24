package ie.wellbeing.repository;

import ie.wellbeing.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDao extends JpaRepository<UserRegistration, Long> {

    UserRegistration findByVerificationCode(String verificationCode);
    UserRegistration findByEmail(String email);
}
