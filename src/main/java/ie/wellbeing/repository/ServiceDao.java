package ie.wellbeing.repository;

import ie.wellbeing.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDao extends JpaRepository<Service, Integer> {

    Service findByServiceNameContainingIgnoreCase(String serviceName);
}
