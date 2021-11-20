package ie.wellbeing.service.impl;


import ie.wellbeing.model.Booking;
import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.model.UserDetails;
import ie.wellbeing.model.dao.BookingDao;
import ie.wellbeing.model.dao.MembershipDetailsDao;
import ie.wellbeing.model.dao.UserDetailsDao;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.PaymentStripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    private EmailServiceImpl emailServiceImpl;

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Autowired
    PaymentStripeService paymentStripeService;

    @Override
    public Booking createBooking(Booking booking) throws Exception {
        try{
            Date currentDate = new Date();

            Optional<UserDetails> userDetails = userDetailsDao.findById(booking.getUserId());
            if(userDetails == null)
            {
                throw new Exception("User Details not found!!!!");
            }
            MembershipDetails membershipDetails = membershipDetailsDao.getMembershipDetailsByuId(booking.getUserId());

            if(membershipDetails != null)
            {
                if (currentDate.compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(membershipDetails.getmEndDate())) > 0)
                {
                    System.out.println("Expired");

                } else if (currentDate.compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(membershipDetails.getmEndDate())) < 0)
                {
                    if (membershipDetails.getmName().equalsIgnoreCase("PLATINUM"))
                    {
                        bookingDao.save(booking);
                        emailServiceImpl.sendSimpleMessage(booking);
                    }
                    else if (membershipDetails.getmName().equalsIgnoreCase("GOLD"))
                    {
                        if(booking.getBookingType().equalsIgnoreCase("Doctor"))
                        {
                            // 100 is the charge for doctor
                            paymentStripeService.createCharge("sairohit349@gmail.com", "123", 100);
                        }

                        bookingDao.save(booking);
                        emailServiceImpl.sendSimpleMessage(booking);

                    } else if (membershipDetails.getmName().equalsIgnoreCase("SILVER"))
                    {
                        if(booking.getBookingType().equalsIgnoreCase("Gym"))
                        {
                            bookingDao.save(booking);
                            emailServiceImpl.sendSimpleMessage(booking);
                        }
                        else
                        {
                            paymentStripeService.createCharge("sairohit349@gmail.com", "123", 340);

                        }
                    }
                }
            }
            else {
                paymentStripeService.createCharge("sairohit349@gmail.com", "123", 700);;
            }

            return booking;
        }
        catch (Exception e){
            throw e;
        }
    }

    public Booking getBookingId(Integer id){
        try
        {
            return bookingDao.findBookingByUserId(id);
        }
        catch (Exception e)
        {
            throw e;
        }
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


}

