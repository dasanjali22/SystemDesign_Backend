package ie.wellbeing.service;

import ie.wellbeing.model.Booking;
import ie.wellbeing.request.BookingRequest;

import java.util.List;

public interface BookingService {

    String createBooking(BookingRequest bookingRequest, String siteURL) throws Exception;
    List<Booking> getAllBooking();
    void updateBookingDetails(Integer paymentId, String type) throws Exception;
}