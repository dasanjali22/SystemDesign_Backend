package ie.wellbeing.service;

import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.request.BookingRequest;

//@author: Sai Rohit Voleti/*
public interface IBookingServicePaymentStrategy {
    boolean ShouldMakePayment(MembershipDetails membershipDetails, BookingRequest bookingRequest);
}
