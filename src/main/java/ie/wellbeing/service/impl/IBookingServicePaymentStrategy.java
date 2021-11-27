package ie.wellbeing.service.impl;

import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.request.BookingRequest;


public interface IBookingServicePaymentStrategy {
    boolean ShouldMakePayment(MembershipDetails membershipDetails, BookingRequest bookingRequest);
}
