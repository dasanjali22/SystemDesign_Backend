package ie.wellbeing.service.impl;


import ie.wellbeing.model.*;
import ie.wellbeing.repository.*;
import ie.wellbeing.DTO.BookingRequestDto;
import ie.wellbeing.DTO.BookingResponseDto;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.ObserverService;
import ie.wellbeing.service.IBookingServicePaymentStrategy;
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
    private ObserverService observerService;

    @Autowired
    private ServiceDetailsRepo serviceListDao;

    @Autowired
    private IBookingServicePaymentStrategy bookingServiceSilverMembershipPaymentStrategy;

    @Autowired
    private IBookingServicePaymentStrategy bookingServiceGoldMembershipPaymentStrategy;

    @Autowired
    private IBookingServicePaymentStrategy bookingServicePlatinumMembershipPaymentStrategy;

    @Override
    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto, String siteURL) {

        List<EmployeeDetails> employeeDetailsList = employeeDetailsRepo.findAll();

        System.out.println(employeeDetailsList);
        EmployeeDetails employeeDetails = employeeDetailsRepo.findByEmployeeName(bookingRequestDto.geteName());

        Booking booking = new Booking();

        booking.setBookingType(bookingRequestDto.getBookingType());
        booking.setSessionSlot(bookingRequestDto.getSessionSlot());
        booking.setUserId(bookingRequestDto.getUserId());
        booking.seteId(employeeDetails.geteId());



        MembershipDetails membershipDetails = membershipDetailsRepo.getMembershipDetailsByuId(bookingRequestDto.getUserId());


        boolean shouldMakePayment = false;

        if(membershipDetails == null)
        {
            shouldMakePayment = true;
        }
        else
        {
            switch (membershipDetails.getmName())
            {

                case "PLATINUM":
                case "Platinum":
                    shouldMakePayment = bookingServicePlatinumMembershipPaymentStrategy.ShouldMakePayment(membershipDetails, bookingRequestDto);
                    break;
                case "GOLD" :
                case "Gold" :
                    shouldMakePayment = bookingServiceGoldMembershipPaymentStrategy.ShouldMakePayment(membershipDetails, bookingRequestDto);
                    break;
                case "SILVER" :
                case "silver" :
                    shouldMakePayment = bookingServiceSilverMembershipPaymentStrategy.ShouldMakePayment(membershipDetails, bookingRequestDto);
                    break;
            }
        }

        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        bookingResponseDto.setBooking(booking);

        if(shouldMakePayment)
        {

            setPaymentDetails(bookingRequestDto, booking, employeeDetails);
            bookingResponseDto.setPaymentUrl(siteURL + "/payment-stripe/charge");

        }

        bookingRepo.save(booking);

        return bookingResponseDto;
    }

    private void setPaymentDetails(BookingRequestDto bookingRequestDto, Booking booking, EmployeeDetails employeeDetails)
    {
        ServiceDetails serviceDetailsList = serviceListDao.findByServiceNameContainingIgnoreCase(bookingRequestDto.getBookingType());

        booking.setServicePrice(serviceDetailsList.getsPrice());
        booking.seteId(employeeDetails.geteId());
        booking.setPaymentStatus(0);

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setPaymentPrice(serviceDetailsList.getsPrice());
        paymentDetails.setPaymentUserId(bookingRequestDto.getUserId());
        paymentDetails.setPaymentStatus(0);
        paymentDetails.setPaymentType(bookingRequestDto.getBookingType());
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