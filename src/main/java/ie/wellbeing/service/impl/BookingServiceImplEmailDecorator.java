package ie.wellbeing.service.impl;

import ie.wellbeing.model.Booking;
import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.request.BookingResponse;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("bookingServiceImplEmailDecorator")
public class BookingServiceImplEmailDecorator implements BookingService
{
    @Autowired
    private BookingService bookingServiceImpl;

    @Autowired
    private EmailService emailService;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest, String siteURL) throws Exception {
        BookingResponse bookingResponse =  bookingServiceImpl.createBooking(bookingRequest, siteURL);
        emailService.sendSimpleMessage(bookingResponse.getBooking());
        return bookingResponse;
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingServiceImpl.getAllBooking();
    }

    @Override
    public void updateBookingDetails(Integer paymentId, String type) throws Exception {
        bookingServiceImpl.updateBookingDetails(paymentId, type);
    }
}
