package ie.wellbeing.service;

import ie.wellbeing.model.PaymentDetails;

import java.util.List;

public interface PaymentService {
    List<PaymentDetails> getAllPaymentDetails();

    PaymentDetails checkUserPaymentId(String email, String serviceType);

}
