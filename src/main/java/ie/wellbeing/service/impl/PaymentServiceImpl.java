package ie.wellbeing.service.impl;

import ie.wellbeing.model.PaymentDetails;
import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.PaymentDetailsDao;
import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService,PaymentServiceProxy {

    @Autowired
    PaymentDetailsDao paymentDetailsDao;

    @Autowired
    private UserDetailsDao userDao;

    @Autowired
    MembershipService membershipService;

    @Autowired
    MembershipContextService membershipContextService;

    @Autowired
    PaymentServiceProxy paymentServiceProxy;

    @Autowired
    BookingService bookingServiceImplEmailDecorator;

    @Override
    public List<PaymentDetails> getAllPaymentDetails() {
        return paymentDetailsDao.findAll();
    }

    @Override
    public PaymentDetails checkUserPaymentId(String email, String serviceType) {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        String createdDate = ft.format(today);

        UserRegistration userDetails = userDao.findByEmail(email);
        if(userDetails == null)
        {
            throw new IllegalStateException("User Not Found ");
        }

        List<PaymentDetails> paymentDetails = paymentDetailsDao.findByPaymentUserId(userDetails.getId());

        for(PaymentDetails pay : paymentDetails)
        {
            if (pay.getPaymentType().equalsIgnoreCase(serviceType) && pay.getPaymentCreatedDate().equalsIgnoreCase(createdDate)){
                return pay;
            }
        }

        throw new IllegalStateException("Payment Details Not Found");
    }

    @Override
    public void updatePaymentDetails(PaymentDetails paymentDetails) throws Exception {

        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        paymentDetails.setPaymentStatus(1);
        paymentDetails.setPaymentDate(ft.format(today));
        paymentDetailsDao.save(paymentDetails);

        switch (paymentDetails.getPaymentType()){
            case "GOLD":
                membershipService.updateMembershipDetails(paymentDetails.getPaymentUserId(), paymentDetails.getPaymentType());
                MembershipState goldMembershipState = new GoldMembershipServiceImpl();
                membershipContextService.changeStateTo(goldMembershipState, paymentDetails.getPaymentUserId());
                break;
            case "SILVER":
                membershipService.updateMembershipDetails(paymentDetails.getPaymentUserId(), paymentDetails.getPaymentType());
                MembershipState silverMembershipState = new SilverMembershipServiceImpl();
                membershipContextService.changeStateTo(silverMembershipState, paymentDetails.getPaymentUserId());
                break;
            case "PLATINUM":
                membershipService.updateMembershipDetails(paymentDetails.getPaymentUserId(), paymentDetails.getPaymentType());
                MembershipState platinumMembershipState = new PlatinumMembershipServiceImpl();
                membershipContextService.changeStateTo(platinumMembershipState, paymentDetails.getPaymentUserId());
                break;
            case "YOGA":
            case "GYM":
            case "DOCTOR":
            case "DIETITIAN":
            case "Yoga":
            case "Gym":
            case "Doctor":
            case "Dietitian":
                bookingServiceImplEmailDecorator.updateBookingDetails(paymentDetails.getId(), paymentDetails.getPaymentType());
                break;
            default:
                break;
        }
    }
}



