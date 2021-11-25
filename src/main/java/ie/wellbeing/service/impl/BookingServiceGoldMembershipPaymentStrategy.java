package ie.wellbeing.service.impl;

import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.service.IBookingServicePaymentStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bookingServiceGoldMembershipPaymentStrategy")
public class BookingServiceGoldMembershipPaymentStrategy implements IBookingServicePaymentStrategy {
    @Override
    public boolean ShouldMakePayment(MembershipDetails membershipDetails, BookingRequest bookingRequest) {
        return bookingRequest.getBookingType().equalsIgnoreCase("Doctor") || bookingRequest.getBookingType().equalsIgnoreCase("Yoga");
    }
}