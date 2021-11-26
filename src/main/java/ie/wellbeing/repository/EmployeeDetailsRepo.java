package ie.wellbeing.repository;

import ie.wellbeing.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Integer> {

    EmployeeDetails findByEmployeeName(String eName);

}


