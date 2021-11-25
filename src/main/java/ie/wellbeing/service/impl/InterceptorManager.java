package ie.wellbeing.service.impl;

import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.request.BookingResponse;
import ie.wellbeing.service.BookingService;

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

    public BookingResponse filterRequest(BookingRequest bookingRequest, String siteURL) throws Exception
    {
        return interceptorChain.execute(bookingRequest, siteURL);
    }
}
