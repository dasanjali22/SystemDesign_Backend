package ie.wellbeing.model.dao;

import ie.wellbeing.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsDao extends JpaRepository<EmployeeDetailsDao, Integer> {

    UserDetails findByEmployeeId(Integer eId);
}


