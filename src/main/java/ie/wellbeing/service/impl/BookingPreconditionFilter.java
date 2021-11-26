package ie.wellbeing.service.impl;

import ie.wellbeing.model.Booking;
import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.repository.*;
import ie.wellbeing.DTO.BookingRequestDto;
import ie.wellbeing.service.IFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class BookingPreconditionFilter implements IFilter{

    @Autowired
    PaymentDetailsRepo paymentDetailsRepo;

    @Autowired
    EmployeeDetailsRepo employeeDetailsRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private MembershipDetailsRepo membershipDetailsRepo;

    @Autowired
    private UserRegistrationRepo userRegistrationRepo;

    @Override
    public void verifyBooking(BookingRequestDto bookingRequestDto) throws Exception
    {

        if(userRegistrationRepo.findById(bookingRequestDto.getUserId()) == null)
        {
            throw new Exception("User Not found");
        }

        List<Booking> bookingCheck = bookingRepo.findBySessionSlot(bookingRequestDto.getSessionSlot());

        if (bookingCheck.size() > 0) {
            for (Booking booking : bookingCheck) {
                if (booking.getUserId().equals(bookingRequestDto.getUserId()) && booking.getBookingType().equalsIgnoreCase(bookingRequestDto.getBookingType())) {
                    throw new Exception("Booking already exist for today. Please come back tomorrow!");
                }
            }
        }

        MembershipDetails membershipDetails = membershipDetailsRepo.getMembershipDetailsByuId(bookingRequestDto.getUserId());

        if (membershipDetails != null) {
            if (new Date().compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(membershipDetails.getmEndDate())) > 0) {
                throw new Exception("Expired");
            }
        }
    }
}
