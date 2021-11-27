package ie.wellbeing.service.impl;

import ie.wellbeing.model.PaymentDetails;
import ie.wellbeing.service.*;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;

public class PaymentServiceProxyImpl implements PaymentServiceProxy {

    @Autowired
    PaymentServiceProxy paymentServiceProxy;

    @Override
    @Transactional
    public void updatePaymentDetails(PaymentDetails paymentDetails) throws Exception {
       System.out.println("updatePaymentstarted");
        paymentServiceProxy.updatePaymentDetails(paymentDetails);
        System.out.println("updatePaymentcompleted");

    }
}
