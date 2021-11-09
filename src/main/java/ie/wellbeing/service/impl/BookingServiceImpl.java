package ie.wellbeing.service.impl;


import ie.wellbeing.model.Booking;
import ie.wellbeing.model.dao.BookingDao;
import ie.wellbeing.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingDao bookingDao;
    @Override
    public Booking createBooking(Booking booking) {
        return bookingDao.save(booking);
    }

    public Booking getBookingId(Integer id){
        return bookingDao.findBookingByUserId(id);
    }
    public List<Booking> getAllBooking(){
        return bookingDao.findAll();
    }
}
