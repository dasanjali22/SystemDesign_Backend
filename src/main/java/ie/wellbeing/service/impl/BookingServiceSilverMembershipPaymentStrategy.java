package ie.wellbeing.service.impl;

import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.request.BookingRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
//@author: Sai Rohit Voleti/*
@Service
@Qualifier("bookingServiceSilverMembershipPaymentStrategy")
public class BookingServiceSilverMembershipPaymentStrategy implements IBookingServicePaymentStrategy{
    @Override
    public boolean ShouldMakePayment(MembershipDetails membershipDetails, BookingRequest bookingRequest) {
        return !bookingRequest.getBookingType().equalsIgnoreCase("Gym");
    }
}
