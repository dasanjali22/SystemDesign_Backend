package ie.wellbeing.service;

import ie.wellbeing.model.PaymentDetails;

public interface PaymentServiceProxy {
    void updatePaymentDetails(PaymentDetails paymentDetails) throws Exception;
}
