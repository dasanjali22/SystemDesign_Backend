package ie.wellbeing.service;

import ie.wellbeing.model.Booking;

import java.util.List;

public interface BookingService {

    Booking createBooking(Booking booking) throws Exception;
    List<Booking> getAllBooking();
    Booking getBookingId(Integer id);
}