package ie.wellbeing.service.impl;

import ie.wellbeing.request.BookingRequest;

public interface IFilter {

    void verifyBooking(BookingRequest bookingRequest) throws Exception;
}
