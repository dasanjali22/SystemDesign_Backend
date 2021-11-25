package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.model.Booking;
import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.request.BookingResponse;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.impl.IFilter;
import ie.wellbeing.service.impl.InterceptorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("booking")
public class BookingController {

    @Autowired
    private BookingService bookingServiceImplEmailDecorator;

    @Autowired
    private IFilter filter;

    @PostMapping(value = "/createBooking" )
    public BookingResponse createBooking(@RequestBody BookingRequest bookingRequest, HttpServletRequest request) throws Exception {
        InterceptorManager interceptorManager = new InterceptorManager(bookingServiceImplEmailDecorator);
        interceptorManager.setFilter(filter);
        return interceptorManager.filterRequest(bookingRequest, getSiteURL(request));
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/getUsers")
    public ApiResponse getAllUsers() {
        return ApiResponseBuilder.success().data(bookingServiceImplEmailDecorator.getAllBooking()).build(); }

    @GetMapping("/all")
    public List<Booking> getAllBookings(){
        return bookingServiceImplEmailDecorator.getAllBooking();
    }
}