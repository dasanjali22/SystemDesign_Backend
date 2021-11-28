package ie.wellbeing.service;

import ie.wellbeing.model.Booking;
import ie.wellbeing.DTO.BookingRequestDto;
import ie.wellbeing.DTO.BookingResponseDto;

import java.util.List;

public interface BookingService {

    BookingResponseDto createBooking(BookingRequestDto bookingRequestDto, String siteURL) throws Exception;
    List<Booking> getAllBooking();
    void updateBookingDetails(Integer paymentId, String type) throws Exception;
}