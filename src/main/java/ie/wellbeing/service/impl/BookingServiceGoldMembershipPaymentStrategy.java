package ie.wellbeing.service.impl;

import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.DTO.BookingRequestDto;
import ie.wellbeing.service.IBookingServicePaymentStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bookingServiceGoldMembershipPaymentStrategy")
public class BookingServiceGoldMembershipPaymentStrategy implements IBookingServicePaymentStrategy {
    @Override
    public boolean ShouldMakePayment(MembershipDetails membershipDetails, BookingRequestDto bookingRequestDto) {
        return bookingRequestDto.getBookingType().equalsIgnoreCase("Doctor") || bookingRequestDto.getBookingType().equalsIgnoreCase("Yoga");
    }
}