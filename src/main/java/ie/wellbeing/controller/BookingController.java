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
    private BookingService observerServiceImplDemo;

    @Autowired
    private IFilter filter;

    @PostMapping(value = "/createBooking" )
    public BookingResponse createBooking(@RequestBody BookingRequest bookingRequest, HttpServletRequest request) throws Exception {
        try {// To simulate the Interceptor pattern, we use Interceptor Manager
            // This is the manager for Interceptor and the target is set that is Observer service Demo
            InterceptorManager interceptorManager = new InterceptorManager(observerServiceImplDemo);
            // This is the part where we set the filter which is BookingPreconditionFilter
            // We can add more
            interceptorManager.setFilter(filter);
            return interceptorManager.filterRequest(bookingRequest, getSiteURL(request));
        }
        catch (Exception e){
            throw e;
        }
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/getUsers")
    public ApiResponse getAllUsers() {
        return ApiResponseBuilder.success().data(observerServiceImplDemo.getAllBooking()).build(); }

    @GetMapping("/all")
    public List<Booking> getAllBookings(){
        return observerServiceImplDemo.getAllBooking();
    }
}