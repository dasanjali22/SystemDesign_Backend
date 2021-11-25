package ie.wellbeing.repository;

import ie.wellbeing.model.ServiceList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceListDao extends JpaRepository<ServiceList, Integer> {

    ServiceList findByServiceName(String serviceName);
}
