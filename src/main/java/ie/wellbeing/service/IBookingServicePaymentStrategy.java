package ie.wellbeing.service;

import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.DTO.BookingRequestDto;


public interface IBookingServicePaymentStrategy {
    boolean ShouldMakePayment(MembershipDetails membershipDetails, BookingRequestDto bookingRequestDto);
}
