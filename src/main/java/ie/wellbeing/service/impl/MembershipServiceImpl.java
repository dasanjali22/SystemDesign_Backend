package ie.wellbeing.service.impl;

import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.model.PaymentDetails;
import ie.wellbeing.model.dao.MembershipDetailsDao;
import ie.wellbeing.model.dao.PaymentDetailsDao;
import ie.wellbeing.request.MembershipRequest;
import ie.wellbeing.service.MembershipService;
import ie.wellbeing.service.MembershipState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService {

    @Autowired
    PaymentDetailsDao paymentDetailsDao;

    @Autowired
    MembershipDetailsDao membershipDetailsDao;

    @Override
    public String createMembership(MembershipRequest membershipRequest, String siteURL) throws Exception {
        PaymentDetails paymentDetails = new PaymentDetails();
        int membershipPrice;
        int membershipId;
        switch (membershipRequest.getmName()){
            case "GOLD":
                MembershipState goldMembershipState = new GoldMembershipServiceImpl();
                membershipPrice = goldMembershipState.membershipPrice();
                membershipId = goldMembershipState.membershipId();
                paymentDetails.setPaymentPrice(membershipPrice);
                paymentDetails.setPaymentUserId(membershipRequest.getuId());
                paymentDetails.setPaymentStatus(0);
                paymentDetails.setPaymentType("GOLD");
                paymentDetailsDao.save(paymentDetails);
                break;
            case "SILVER":
                MembershipState silverMembershipState = new SilverMembershipServiceImpl();
                membershipPrice = silverMembershipState.membershipPrice();
                membershipId = silverMembershipState.membershipId();
                paymentDetails.setPaymentPrice(membershipPrice);
                paymentDetails.setPaymentUserId(membershipRequest.getuId());
                paymentDetails.setPaymentStatus(0);
                paymentDetails.setPaymentType("SILVER");
                paymentDetailsDao.save(paymentDetails);
                break;
            case "PLATINUM":
                MembershipState platinumMembershipState = new PlatinumMembershipServiceImpl();
                membershipPrice= platinumMembershipState.membershipPrice();
                membershipId = platinumMembershipState.membershipId();
                paymentDetails.setPaymentPrice(membershipPrice);
                paymentDetails.setPaymentUserId(membershipRequest.getuId());
                paymentDetails.setPaymentStatus(0);
                paymentDetails.setPaymentType("PLATINUM");
                paymentDetailsDao.save(paymentDetails);
                break;
            default:
                break;
        }
        return siteURL+"/payment-stripe/charge";
    }

    @Override
    public void updateMembershipDetails(Integer userId, String type) {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        Date nextYear = cal.getTime();
        MembershipDetails membershipDetails = new MembershipDetails();
        membershipDetails.setmName(type);
        membershipDetails.setuId(userId);
        membershipDetails.setmStartDate(ft.format(today));
        membershipDetails.setmEndDate(ft.format(nextYear));
        membershipDetailsDao.save(membershipDetails);
    }

    @Override
    public List<MembershipDetails> getAllUsersMembershipDetails() {
        return membershipDetailsDao.findAll();
    }
}
