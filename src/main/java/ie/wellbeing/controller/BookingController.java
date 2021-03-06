package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.model.Booking;
import ie.wellbeing.DTO.BookingRequestDto;
import ie.wellbeing.DTO.BookingResponseDto;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.IFilter;
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
    public BookingResponseDto createBooking(@RequestBody BookingRequestDto bookingRequestDto, HttpServletRequest request) throws Exception {
        try {// To simulate the Interceptor pattern, we use Interceptor Manager
            // This is the manager for Interceptor and the target is set that is email decorator
            // Ideally, it is the BookingServiceImpl but we decorated with Email for Decorator pattern
            InterceptorManager interceptorManager = new InterceptorManager(bookingServiceImplEmailDecorator);
            // This is the part where we set the filter which is BookingPreconditionFilter
            // We can add more
            interceptorManager.setFilter(filter);
            return interceptorManager.filterRequest(bookingRequestDto, getSiteURL(request));
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
        return ApiResponseBuilder.success().data(bookingServiceImplEmailDecorator.getAllBooking()).build(); }

    @GetMapping("/all")
    public List<Booking> getAllBookings(){
        return bookingServiceImplEmailDecorator.getAllBooking();
    }
}