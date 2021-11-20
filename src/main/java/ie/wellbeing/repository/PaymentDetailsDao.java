package ie.wellbeing.repository;

import ie.wellbeing.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsDao extends JpaRepository<PaymentDetails, Integer> {

    PaymentDetails findByPaymentUserId(Integer id);
}
