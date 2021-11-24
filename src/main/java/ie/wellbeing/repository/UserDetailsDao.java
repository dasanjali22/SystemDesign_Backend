package ie.wellbeing.repository;

import ie.wellbeing.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsDao extends JpaRepository<UserDetails, Integer> {

    UserDetails findByVerificationCode(String verificationCode);
    UserDetails findByEmail(String email);
}
