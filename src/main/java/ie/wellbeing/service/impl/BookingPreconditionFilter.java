package ie.wellbeing.service.impl;

import ie.wellbeing.model.Booking;
import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.repository.*;
import ie.wellbeing.request.BookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class BookingPreconditionFilter implements IFilter{

    @Autowired
    PaymentDetailsDao paymentDetailsDao;

    @Autowired
    EmployeeDetailsDao employeeDetailsDao;

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private MembershipDetailsDao membershipDetailsDao;

    @Override
    public void verifyBooking(BookingRequest bookingRequest) throws Exception
    {

        List<Booking> bookingCheck = bookingDao.findBySessionSlot(bookingRequest.getSessionSlot());

        if (bookingCheck.size() > 0) {
            for (Booking booking : bookingCheck) {
                if (booking.getUserId().equals(bookingRequest.getUserId()) && booking.getBookingType().equalsIgnoreCase(bookingRequest.getBookingType())) {
                    throw new Exception("Booking already exist for today. Please come back tomorrow!");
                }
            }
        }

        MembershipDetails membershipDetails = membershipDetailsDao.getMembershipDetailsByuId(bookingRequest.getUserId());

        if(membershipDetails == null)
        {
            throw new Exception("No Membership");
        }

        if (membershipDetails != null) {
            if (new Date().compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(membershipDetails.getmEndDate())) > 0) {
                throw new Exception("Expired");
            }
        }
    }
}
