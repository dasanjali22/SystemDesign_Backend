package ie.wellbeing.service.impl;

import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.request.BookingResponse;
import ie.wellbeing.service.BookingService;

import java.util.ArrayList;
import java.util.List;

public class InterceptorChain {

    private final List<IFilter> filters = new ArrayList<>();

    private BookingService bookingService;

    public void addFilter(IFilter filter)
    {
        filters.add(filter);
    }

    public BookingResponse execute(BookingRequest bookingRequest, String siteURL) throws Exception
    {
        for (IFilter filter : filters) {
            filter.verifyBooking(bookingRequest);
        }

        return bookingService.createBooking(bookingRequest, siteURL);
    }

    public void setBookingService(BookingService bookingService)
    {
        this.bookingService = bookingService;
    }
}
