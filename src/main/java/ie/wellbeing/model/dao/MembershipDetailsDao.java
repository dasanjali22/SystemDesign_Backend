package ie.wellbeing.model.dao;

import ie.wellbeing.model.MembershipDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipDetailsDao extends JpaRepository<MembershipDetails, Integer> {

}
