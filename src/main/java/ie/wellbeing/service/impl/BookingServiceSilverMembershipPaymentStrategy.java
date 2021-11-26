package ie.wellbeing.service.impl;

import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.DTO.BookingRequestDto;
import ie.wellbeing.service.IBookingServicePaymentStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
//@author: Sai Rohit Voleti/*
@Service
@Qualifier("bookingServiceSilverMembershipPaymentStrategy")
public class BookingServiceSilverMembershipPaymentStrategy implements IBookingServicePaymentStrategy {
    @Override
    public boolean ShouldMakePayment(MembershipDetails membershipDetails, BookingRequestDto bookingRequestDto) {
        return !bookingRequestDto.getBookingType().equalsIgnoreCase("Gym");
    }
}
