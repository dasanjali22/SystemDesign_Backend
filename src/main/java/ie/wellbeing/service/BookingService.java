package ie.wellbeing.service;

import ie.wellbeing.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    Booking createBooking(Booking booking);
    List<Booking> getAllBooking();
    Booking getBookingId(Integer id);
}
