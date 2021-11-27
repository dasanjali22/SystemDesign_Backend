package ie.wellbeing.service.impl;

import ie.wellbeing.model.Booking;
import ie.wellbeing.model.EmployeeDetails;
import ie.wellbeing.model.PaymentDetails;
import ie.wellbeing.repository.BookingDao;
import ie.wellbeing.repository.EmployeeDetailsDao;
import ie.wellbeing.repository.PaymentDetailsDao;
import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.request.BookingResponse;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.ObserverEmployeeService;
import ie.wellbeing.service.ObserverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Qualifier("observerServiceImpl")
public class ObserverServiceImpl implements BookingService
{
    @Autowired
    private BookingService bookingServiceImpl;

    @Autowired
    private ObserverUserService emailService;

    @Autowired
    private ObserverEmployeeService observerEmployeeService;

    @Autowired
    private EmployeeDetailsDao employeeDetailsDao;

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private PaymentDetailsDao paymentDetailsDao;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest, String siteURL) throws Exception {
        BookingResponse bookingResponse =  bookingServiceImpl.createBooking(bookingRequest, siteURL);
        if(bookingResponse.getPaymentUrl() == null || bookingResponse.getPaymentUrl().equals(""))
        {
            emailService.sendSimpleMessage(bookingResponse.getBooking());
            Optional<EmployeeDetails> employeeDetailsOptional = employeeDetailsDao.findById(bookingResponse.booking.geteId());
            observerEmployeeService.sendSimpleMessage(employeeDetailsOptional.orElse(null), bookingResponse.getBooking());
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
        PaymentDetails paymentDetails = paymentDetailsDao.getById(paymentId);
        List<Booking> bookingCheck = bookingDao.findByUserId(paymentDetails.getPaymentUserId());
        if (bookingCheck.size() > 0) {
            for (Booking booking : bookingCheck) {
                if (booking.getBookingType().equals(type)) {
                    emailService.sendSimpleMessage(booking);
                    Optional<EmployeeDetails> employeeDetailsOptional = employeeDetailsDao.findById(booking.geteId());
                    observerEmployeeService.sendSimpleMessage(employeeDetailsOptional.orElse(null), booking);
                }
            }
        }
    }
}
