package ie.wellbeing.repository;

import ie.wellbeing.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails, Integer> {
    List<PaymentDetails> findByPaymentUserId(Long id);
}