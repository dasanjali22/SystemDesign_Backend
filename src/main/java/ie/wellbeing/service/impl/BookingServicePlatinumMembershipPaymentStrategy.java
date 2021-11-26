package ie.wellbeing.service.impl;

import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.request.BookingRequest;
import ie.wellbeing.service.IBookingServicePaymentStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bookingServicePlatinumMembershipPaymentStrategy")

public class BookingServicePlatinumMembershipPaymentStrategy implements IBookingServicePaymentStrategy {
    @Override
    public boolean ShouldMakePayment(MembershipDetails membershipDetails, BookingRequest bookingRequest) {

        return false;
    }

}
