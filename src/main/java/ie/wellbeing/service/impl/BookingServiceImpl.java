package ie.wellbeing.service.impl;


import ie.wellbeing.model.*;
import ie.wellbeing.repository.*;
import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
Authors : Sai Rohit Voleti & Subhiksha
 */
@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private MembershipDetailsDao membershipDetailsDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Autowired
    private ServiceListDao serviceListDao;

    @Autowired
    PaymentDetailsDao paymentDetailsDao;

    @Autowired
    EmployeeDetailsDao employeeDetailsDao;

    @Override
    public String createBooking(BookingRequest bookingRequest, String siteURL) throws Exception {

            Date currentDate = new Date();

            UserRegistration userRegistration = userDetailsDao.getById(bookingRequest.getUserId());

            ServiceList serviceList = serviceListDao.findByServiceName(bookingRequest.getBookingType());

            EmployeeDetails employeeDetails = employeeDetailsDao.findByEmployeeName(bookingRequest.geteName());

            List<Booking> bookingCheck = bookingDao.findBySessionSlot(bookingRequest.getSessionSlot());

            if(bookingCheck.size()>0){
                for(Booking booking : bookingCheck){
                    if(booking.getUserId().equals(bookingRequest.getUserId()) && booking.getBookingType().equalsIgnoreCase(bookingRequest.getBookingType())){
                        return "Booking already exist for today. Please come back tomorrow!";
                    }

                }
            }

            PaymentDetails paymentDetails = new PaymentDetails();

            Booking booking = new Booking();

             SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
              Calendar cal = Calendar.getInstance();
              Date today = cal.getTime();

            if(userRegistration == null)
            {
                throw new Exception("User Details not found!!!!");
            }
            MembershipDetails membershipDetails = membershipDetailsDao.getMembershipDetailsByuId(bookingRequest.getUserId());

            if(membershipDetails != null)
            {
                if (currentDate.compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(membershipDetails.getmEndDate())) > 0)
                {
                    System.out.println("Expired");

                }
                else if (currentDate.compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(membershipDetails.getmEndDate())) < 0)
                {
                    if (membershipDetails.getmName().equalsIgnoreCase("PLATINUM"))
                    {
                        booking.setBookingType(bookingRequest.getBookingType());
                        booking.setSessionSlot(bookingRequest.getSessionSlot());
                        booking.setUserId(bookingRequest.getUserId());
                        booking.seteId(employeeDetails.geteId());
                        bookingDao.save(booking);
                        emailService.sendSimpleMessage(booking);
                    }
                    else if (membershipDetails.getmName().equalsIgnoreCase("GOLD"))
                    {
                        if(bookingRequest.getBookingType().equalsIgnoreCase("Doctor") || bookingRequest.getBookingType().equalsIgnoreCase("Gym"))
                        {
                            booking.setBookingType(bookingRequest.getBookingType());
                            booking.setSessionSlot(bookingRequest.getSessionSlot());
                            booking.setUserId(bookingRequest.getUserId());
                            booking.seteId(employeeDetails.geteId());
                            bookingDao.save(booking);
                            emailService.sendSimpleMessage(booking);
                        }
                        else {
                            booking.setBookingType(bookingRequest.getBookingType());
                            booking.setSessionSlot(bookingRequest.getSessionSlot());
                            booking.setUserId(bookingRequest.getUserId());
                            booking.setServicePrice(serviceList.getsPrice());
                            booking.seteId(employeeDetails.geteId());
                            booking.setPaymentStatus(0);
                            bookingDao.save(booking);
                            paymentDetails.setPaymentPrice(serviceList.getsPrice());
                            paymentDetails.setPaymentUserId(bookingRequest.getUserId());
                            paymentDetails.setPaymentStatus(0);
                            paymentDetails.setPaymentCreatedDate(ft.format(today));
                            paymentDetails.setPaymentType(bookingRequest.getBookingType());
                            paymentDetailsDao.save(paymentDetails);
                            return siteURL+"/payment-stripe/charge";
                        }

                    }
                    else if (membershipDetails.getmName().equalsIgnoreCase("SILVER"))
                    {
                        if(bookingRequest.getBookingType().equalsIgnoreCase("Gym"))
                        {
                            booking.setBookingType(bookingRequest.getBookingType());
                            booking.setSessionSlot(bookingRequest.getSessionSlot());
                            booking.setUserId(bookingRequest.getUserId());
                            booking.seteId(employeeDetails.geteId());
                            bookingDao.save(booking);
                            emailService.sendSimpleMessage(booking);
                        }
                        else
                        {
                            booking.setBookingType(bookingRequest.getBookingType());
                            booking.setSessionSlot(bookingRequest.getSessionSlot());
                            booking.setUserId(bookingRequest.getUserId());
                            booking.setServicePrice(serviceList.getsPrice());
                            booking.seteId(employeeDetails.geteId());
                            booking.setPaymentStatus(0);
                            bookingDao.save(booking);
                            paymentDetails.setPaymentPrice(serviceList.getsPrice());
                            paymentDetails.setPaymentUserId(bookingRequest.getUserId());
                            paymentDetails.setPaymentStatus(0);
                            paymentDetails.setPaymentType(bookingRequest.getBookingType());
                            paymentDetails.setPaymentCreatedDate(ft.format(today));
                            paymentDetailsDao.save(paymentDetails);
                            return siteURL+"/payment-stripe/charge";

                        }
                    }
                    else{
                        return "Booking not Successful";
                    }
                }
            }
                return "Booking Successful";

        }

    public List<Booking> getAllBooking(){
        try
        {
            return bookingDao.findAll();
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public void updateBookingDetails(Integer paymentId, String type) throws Exception {
        PaymentDetails paymentDetails = paymentDetailsDao.getById(paymentId);
        List<Booking> bookingCheck = bookingDao.findByUserId(paymentDetails.getPaymentUserId());
        if(bookingCheck.size()>0){
            for(Booking booking : bookingCheck){
                if(booking.getBookingType().equals(type)){
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

