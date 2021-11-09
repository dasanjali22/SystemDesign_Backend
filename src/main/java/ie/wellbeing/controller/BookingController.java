package ie.wellbeing.controller;

import ie.wellbeing.model.Booking;
import ie.wellbeing.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/")
    public Booking createBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }

   @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Integer id){
        return bookingService.git getBookingId(id);
   }

   @GetMapping("/all")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBooking();
   }
}
