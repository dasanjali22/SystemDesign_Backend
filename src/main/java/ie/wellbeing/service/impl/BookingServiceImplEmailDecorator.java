package ie.wellbeing.service.impl;

import ie.wellbeing.model.Booking;
import ie.wellbeing.model.EmployeeDetails;
import ie.wellbeing.repository.EmployeeDetailsDao;
import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.request.BookingResponse;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@author: Sai Rohit Voleti/*
@Service
@Qualifier("bookingServiceImplEmailDecorator")
public class BookingServiceImplEmailDecorator implements BookingService
{
    @Autowired
    private BookingService bookingServiceImpl;

    @Autowired
    private NotificationService emailService;

    @Autowired
    private EmployeeDetailsDao employeeDetailsDao;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest, String siteURL) throws Exception {
        BookingResponse bookingResponse =  bookingServiceImpl.createBooking(bookingRequest, siteURL);
        emailService.sendSimpleMessage(bookingResponse.getBooking());
        Optional<EmployeeDetails> employeeDetailsOptional = employeeDetailsDao.findById(bookingResponse.booking.geteId());
        emailService.sendSimpleMessage(employeeDetailsOptional.isPresent() ? employeeDetailsOptional.get() : null, bookingResponse.getBooking());
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
