package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
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

    @PostMapping(value = "/",headers =  "content-type=application/json" )
    @ResponseBody
    public Booking createBooking(@RequestBody Booking booking) throws Exception {
        try {
            return bookingService.createBooking(booking);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @GetMapping("/getUsers")
    public ApiResponse getAllUsers() {
        return ApiResponseBuilder.success().data(bookingService.getAllBooking()).build(); }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Integer id){
        return bookingService.getBookingId(id);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBooking();
    }
}