package ie.wellbeing.service.impl;

import ie.wellbeing.model.Booking;
import ie.wellbeing.model.EmployeeDetails;
import ie.wellbeing.model.PaymentDetails;
import ie.wellbeing.repository.BookingRepo;
import ie.wellbeing.repository.EmployeeDetailsRepo;
import ie.wellbeing.repository.PaymentDetailsRepo;
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
    private EmployeeDetailsRepo employeeDetailsRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private PaymentDetailsRepo paymentDetailsRepo;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest, String siteURL) throws Exception {
        BookingResponse bookingResponse =  bookingServiceImpl.createBooking(bookingRequest, siteURL);
        if(bookingResponse.getPaymentUrl() == null || bookingResponse.getPaymentUrl().equals(""))
        {
            emailService.sendSimpleMessage(bookingResponse.getBooking());
            Optional<EmployeeDetails> employeeDetailsOptional = employeeDetailsRepo.findById(bookingResponse.booking.geteId());
            emailService.sendSimpleMessage(employeeDetailsOptional.orElse(null), bookingResponse.getBooking());
        }
        return bookingResponse;
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingServiceImpl.getAllBooking();
    }

    @Override
    public void updateBookingDetails(Integer paymentId, String type) throws Exception {
        bookingServiceImpl.updateBookingDetails(paymentId, type);
        PaymentDetails paymentDetails = paymentDetailsRepo.getById(paymentId);
        List<Booking> bookingCheck = bookingRepo.findByUserId(paymentDetails.getPaymentUserId());
        if (bookingCheck.size() > 0) {
            for (Booking booking : bookingCheck) {
                if (booking.getBookingType().equals(type)) {
                    emailService.sendSimpleMessage(booking);
                    Optional<EmployeeDetails> employeeDetailsOptional = employeeDetailsRepo.findById(booking.geteId());
                    emailService.sendSimpleMessage(employeeDetailsOptional.orElse(null), booking);
                }
            }
        }
    }
}