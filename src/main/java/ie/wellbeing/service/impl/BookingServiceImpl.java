package ie.wellbeing.service.impl;


import ie.wellbeing.model.*;
import ie.wellbeing.repository.*;
import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.request.BookingResponse;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.IBookingServicePaymentStrategy;
import ie.wellbeing.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
Authors : Sai Rohit Voleti & Subhiksha
 */

@org.springframework.stereotype.Service
@Qualifier("bookingServiceImpl")
public class BookingServiceImpl implements BookingService {
    @Autowired
    PaymentDetailsRepo paymentDetailsRepo;

    @Autowired
    EmployeeDetailsRepo employeeDetailsRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private MembershipDetailsRepo membershipDetailsRepo;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ServiceDetailsRepo serviceListDao;

    @Autowired
    private IBookingServicePaymentStrategy bookingServiceSilverMembershipPaymentStrategy;

    @Autowired
    private IBookingServicePaymentStrategy bookingServiceGoldMembershipPaymentStrategy;

    @Autowired
    private IBookingServicePaymentStrategy bookingServicePlatinumMembershipPaymentStrategy;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest, String siteURL) {

        List<EmployeeDetails> employeeDetailsList = employeeDetailsRepo.findAll();

        System.out.println(employeeDetailsList);
        EmployeeDetails employeeDetails = employeeDetailsRepo.findByEmployeeName(bookingRequest.geteName());

        Booking booking = new Booking();

        booking.setBookingType(bookingRequest.getBookingType());
        booking.setSessionSlot(bookingRequest.getSessionSlot());
        booking.setUserId(bookingRequest.getUserId());
        booking.seteId(employeeDetails.geteId());

        MembershipDetails membershipDetails = membershipDetailsRepo.getMembershipDetailsByuId(bookingRequest.getUserId());

        boolean shouldMakePayment = false;

        if(membershipDetails == null)
        {
            shouldMakePayment = true;
        }
        else
        {
            switch (membershipDetails.getmName())
            {
                // Not using enum, stupid cases
                case "PLATINUM":
                case "Platinum":
                    shouldMakePayment = bookingServicePlatinumMembershipPaymentStrategy.ShouldMakePayment(membershipDetails, bookingRequest);
                    break;
                case "GOLD" :
                case "Gold" :
                    shouldMakePayment = bookingServiceGoldMembershipPaymentStrategy.ShouldMakePayment(membershipDetails, bookingRequest);
                    break;
                case "SILVER" :
                case "silver" :
                    shouldMakePayment = bookingServiceSilverMembershipPaymentStrategy.ShouldMakePayment(membershipDetails, bookingRequest);
                    break;
            }
        }

        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBooking(booking);

        if(shouldMakePayment)
        {
            setPaymentDetails(bookingRequest, booking, employeeDetails);
            bookingResponse.setPaymentUrl(siteURL + "/payment-stripe/charge");
        }

        bookingRepo.save(booking);

        return bookingResponse;
    }

    private void setPaymentDetails(BookingRequest bookingRequest, Booking booking, EmployeeDetails employeeDetails)
    {
        ServiceDetails serviceDetailsList = serviceListDao.findByServiceNameContainingIgnoreCase(bookingRequest.getBookingType());

        booking.setServicePrice(serviceDetailsList.getsPrice());
        booking.seteId(employeeDetails.geteId());
        booking.setPaymentStatus(0);

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setPaymentPrice(serviceDetailsList.getsPrice());
        paymentDetails.setPaymentUserId(bookingRequest.getUserId());
        paymentDetails.setPaymentStatus(0);
        paymentDetails.setPaymentType(bookingRequest.getBookingType());
        paymentDetails.setPaymentCreatedDate(new SimpleDateFormat ("yyyy-MM-dd").format(new Date()));
        paymentDetailsRepo.save(paymentDetails);
    }

    public List<Booking> getAllBooking() {
        return bookingRepo.findAll();
    }

    @Override
    public void updateBookingDetails(Integer paymentId, String type) throws Exception {
        PaymentDetails paymentDetails = paymentDetailsRepo.getById(paymentId);
        List<Booking> bookingCheck = bookingRepo.findByUserId(paymentDetails.getPaymentUserId());
        if (bookingCheck.size() > 0) {
            for (Booking booking : bookingCheck) {
                if (booking.getBookingType().equals(type)) {
                    paymentDetails.setPaymentStatus(1);
                    booking.setPaymentStatus(1);
                    bookingRepo.save(booking);
                    paymentDetailsRepo.save(paymentDetails);
                }
            }
        }
    }
}