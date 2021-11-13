package ie.wellbeing.service.impl;

import ie.wellbeing.model.PaymentDetails;
import ie.wellbeing.model.UserDetails;
import ie.wellbeing.model.dao.PaymentDetailsDao;
import ie.wellbeing.model.dao.UserDetailsDao;
import ie.wellbeing.service.MembershipContextService;
import ie.wellbeing.service.MembershipService;
import ie.wellbeing.service.MembershipState;
import ie.wellbeing.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDetailsDao paymentDetailsDao;

    @Autowired
    private UserDetailsDao userDao;

    @Autowired
    MembershipService membershipService;

    @Autowired
    MembershipContextService membershipContextService;

    @Override
    public List<PaymentDetails> getAllPaymentDetails() {
        return paymentDetailsDao.findAll();
    }

    @Override
    public PaymentDetails checkUserPaymentId(String email) {
        UserDetails userOptional = userDao.findByEmail(email);
        if(userOptional!=null){
            PaymentDetails paymentDetails = paymentDetailsDao.findByPaymentUserId(userOptional.getId());
            if(paymentDetails!=null){
                return paymentDetails;
            }else {
                throw new IllegalStateException("Payment Details Not Found");
            }
        }else{
            throw new IllegalStateException("User Not Found ");
        }
    }

    @Override
    @Transactional
    public void updatePaymentDetails(PaymentDetails paymentDetails) {
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
            default:
                break;
        }
    }
}
