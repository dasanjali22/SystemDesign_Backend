package ie.wellbeing.service.impl;


import ie.wellbeing.model.Booking;
import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.model.dao.BookingDao;
import ie.wellbeing.model.dao.MembershipDetailsDao;
import ie.wellbeing.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private MembershipDetailsDao membershipDetailsDao;

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @Override
    public Booking createBooking(Booking booking) throws ParseException, MessagingException, UnsupportedEncodingException {
        Booking booking1 = bookingDao.save(booking);
        String session_time = booking.getSessionTime();
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss", Locale.ENGLISH);
        Date sessiondate = formatter.parse(session_time);
        MembershipDetails membershipDetails = null;
        if (currentDate.compareTo(sessiondate) > 0) {
            System.out.println("Expired");
        } else if (currentDate.compareTo(sessiondate) < 0) {
            membershipDetails = membershipDetailsDao.getMembershipDetailsByuId(booking.getUserId());
            emailServiceImpl.sendSimpleMessage();
            if (membershipDetails.getmName().equals("PLATINUM")) {

            }
        } else if (membershipDetails.getmName().equals("GOLD")) {

        } else if (membershipDetails.getmName().equals("SILVER"))
        {

        }
            return booking;
    }

    public Booking getBookingId(Integer id){
        return bookingDao.findBookingByUserId(id);
    }
    public List<Booking> getAllBooking(){
        return bookingDao.findAll();
    }


}
