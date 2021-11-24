package ie.wellbeing.service.impl;


import ie.wellbeing.model.*;
import ie.wellbeing.repository.*;
import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.request.BookingResponse;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
Authors : Sai Rohit Voleti & Subhiksha
 */

@Service
@Qualifier("bookingServiceImpl")
public class BookingServiceImpl implements BookingService {
    @Autowired
    PaymentDetailsDao paymentDetailsDao;

    @Autowired
    EmployeeDetailsDao employeeDetailsDao;

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private MembershipDetailsDao membershipDetailsDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ServiceListDao serviceListDao;

    @Autowired
    private IBookingServicePaymentStrategy bookingServiceSilverMembershipPaymentStrategy;

    @Autowired
    private IBookingServicePaymentStrategy bookingServiceGoldMembershipPaymentStrategy;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest, String siteURL) {

        List<EmployeeDetails> employeeDetailsList = employeeDetailsDao.findAll();

        System.out.println(employeeDetailsList);
        EmployeeDetails employeeDetails = employeeDetailsDao.findByEmployeeName(bookingRequest.geteName());

        Booking booking = new Booking();

        booking.setBookingType(bookingRequest.getBookingType());
        booking.setSessionSlot(bookingRequest.getSessionSlot());
        booking.setUserId(bookingRequest.getUserId());
        booking.seteId(employeeDetails.geteId());

        MembershipDetails membershipDetails = membershipDetailsDao.getMembershipDetailsByuId(bookingRequest.getUserId());

        boolean shouldMakePayment = false;

        switch (membershipDetails.getmName())
        {
            // Not using enum, stupid cases
            case "GOLD" :
            case "Gold" :
                shouldMakePayment = bookingServiceGoldMembershipPaymentStrategy.ShouldMakePayment(membershipDetails, bookingRequest);
                break;
            case "SILVER" :
            case "silver" :
                shouldMakePayment = bookingServiceSilverMembershipPaymentStrategy.ShouldMakePayment(membershipDetails, bookingRequest);
                break;
        }

        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBooking(booking);

        if(shouldMakePayment)
        {
            setPaymentDetails(bookingRequest, booking, employeeDetails);
            bookingResponse.setPaymentUrl(siteURL+"/payment-stripe/charge");
        }

        bookingDao.save(booking);

        return bookingResponse;
    }

    private void setPaymentDetails(BookingRequest bookingRequest, Booking booking, EmployeeDetails employeeDetails)
    {
        ServiceList serviceList = serviceListDao.findByServiceName(bookingRequest.getBookingType());

        booking.setServicePrice(serviceList.getsPrice());
        booking.seteId(employeeDetails.geteId());
        booking.setPaymentStatus(0);

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setPaymentPrice(serviceList.getsPrice());
        paymentDetails.setPaymentUserId(bookingRequest.getUserId());
        paymentDetails.setPaymentStatus(0);
        paymentDetails.setPaymentType(bookingRequest.getBookingType());
        paymentDetails.setPaymentCreatedDate(new SimpleDateFormat ("yyyy-MM-dd").format(new Date()));
        paymentDetailsDao.save(paymentDetails);
    }

    public List<Booking> getAllBooking() {
        return bookingDao.findAll();
    }

    @Override
    public void updateBookingDetails(Integer paymentId, String type) throws Exception {
        PaymentDetails paymentDetails = paymentDetailsDao.getById(paymentId);
        List<Booking> bookingCheck = bookingDao.findByUserId(paymentDetails.getPaymentUserId());
        if (bookingCheck.size() > 0) {
            for (Booking booking : bookingCheck) {
                if (booking.getBookingType().equals(type)) {
                    paymentDetails.setPaymentStatus(1);
                    booking.setPaymentStatus(1);
                    bookingDao.save(booking);
                    paymentDetailsDao.save(paymentDetails);
                    emailService.sendSimpleMessage(booking);
                }
            }
        }
    }
}

