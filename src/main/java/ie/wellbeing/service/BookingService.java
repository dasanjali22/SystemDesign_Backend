package ie.wellbeing.service;

import ie.wellbeing.model.Booking;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

@Service
public interface BookingService {

    Booking createBooking(Booking booking) throws ParseException, MessagingException, UnsupportedEncodingException;
    List<Booking> getAllBooking();
    Booking getBookingId(Integer id);
}
