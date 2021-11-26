package ie.wellbeing.service.impl;

import ie.wellbeing.DTO.BookingRequestDto;
import ie.wellbeing.DTO.BookingResponseDto;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.IFilter;

public class InterceptorManager {
    private InterceptorChain interceptorChain;

    public InterceptorManager(BookingService bookingService)
    {
        interceptorChain = new InterceptorChain();
        interceptorChain.setBookingService(bookingService);
    }

    public void setFilter(IFilter filter)
    {
        interceptorChain.addFilter(filter);
    }

    public BookingResponseDto filterRequest(BookingRequestDto bookingRequestDto, String siteURL) throws Exception
    {
        return interceptorChain.execute(bookingRequestDto, siteURL);
    }
}
