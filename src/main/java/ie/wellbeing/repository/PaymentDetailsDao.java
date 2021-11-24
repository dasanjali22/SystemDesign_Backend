package ie.wellbeing.repository;

import ie.wellbeing.model.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public interface PaymentDetailsDao extends JpaRepository<PaymentDetails, Integer> {
    List<PaymentDetails> findByPaymentUserId(Long id);

}
