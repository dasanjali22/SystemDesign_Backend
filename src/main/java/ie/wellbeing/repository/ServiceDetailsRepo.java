package ie.wellbeing.repository;

import ie.wellbeing.model.ServiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDetailsRepo extends JpaRepository<ServiceDetails, Integer> {

    ServiceDetails findByServiceNameContainingIgnoreCase(String serviceName);
}
