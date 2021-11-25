package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.model.Booking;
import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping(value = "/createBooking" )
    public String createBooking(@RequestBody BookingRequest bookingRequest, HttpServletRequest request) throws Exception {
        try {
            return bookingService.createBooking(bookingRequest, getSiteURL(request));
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/getUsers")
    public ApiResponse getAllUsers() {
        return ApiResponseBuilder.success().data(bookingService.getAllBooking()).build(); }

    @GetMapping("/all")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBooking();
    }
}