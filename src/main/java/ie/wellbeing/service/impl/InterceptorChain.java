package ie.wellbeing.service.impl;

import ie.wellbeing.DTO.BookingRequestDto;
import ie.wellbeing.DTO.BookingResponseDto;
import ie.wellbeing.service.BookingService;
import ie.wellbeing.service.IFilter;

import java.util.ArrayList;
import java.util.List;

public class InterceptorChain {

    private final List<IFilter> filters = new ArrayList<>();

    private BookingService bookingService;

    public void addFilter(IFilter filter)
    {
        filters.add(filter);
    }

    public BookingResponseDto execute(BookingRequestDto bookingRequestDto, String siteURL) throws Exception
    {
        for (IFilter filter : filters) {
            filter.verifyBooking(bookingRequestDto);
        }

        return bookingService.createBooking(bookingRequestDto, siteURL);
    }

    public void setBookingService(BookingService bookingService)
    {
        this.bookingService = bookingService;
    }
}
