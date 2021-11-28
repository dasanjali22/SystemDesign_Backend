package ie.wellbeing.service.impl;

import ie.wellbeing.DTO.BookingRequestDto;
import ie.wellbeing.DTO.BookingResponseDto;
import ie.wellbeing.model.Booking;
import ie.wellbeing.model.EmployeeDetails;
import ie.wellbeing.model.PaymentDetails;
import ie.wellbeing.repository.BookingRepo;
import ie.wellbeing.repository.EmployeeDetailsRepo;
import ie.wellbeing.repository.PaymentDetailsRepo;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.ObserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Qualifier("observerServiceImplDemo")
public class ObserverServiceImplDemo implements BookingService
{
    @Autowired
    private BookingService bookingServiceImpl;

    @Autowired
    private ObserverService emailService;

    @Autowired
    private EmployeeDetailsRepo employeeDetailsDao;

    @Autowired
    private BookingRepo bookingDao;

    @Autowired
    private PaymentDetailsRepo paymentDetailsDao;

    @Override
    public BookingResponseDto createBooking(BookingRequestDto bookingRequest, String siteURL) throws Exception {
        BookingResponseDto bookingResponse =  bookingServiceImpl.createBooking(bookingRequest, siteURL);
        if(bookingResponse.getPaymentUrl() == null || bookingResponse.getPaymentUrl().equals(""))
        {
            emailService.sendSimpleMessage(bookingResponse.getBooking());
            Optional<EmployeeDetails> employeeDetailsOptional = employeeDetailsDao.findById(bookingResponse.booking.geteId());
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
        PaymentDetails paymentDetails = paymentDetailsDao.getById(paymentId);
        List<Booking> bookingCheck = bookingDao.findByUserId(paymentDetails.getPaymentUserId());
        if (bookingCheck.size() > 0) {
            for (Booking booking : bookingCheck) {
                if (booking.getBookingType().equals(type)) {
                    emailService.sendSimpleMessage(booking);
                    Optional<EmployeeDetails> employeeDetailsOptional = employeeDetailsDao.findById(booking.geteId());
                    emailService.sendSimpleMessage(employeeDetailsOptional.orElse(null), booking);
                }
            }
        }
    }
}
