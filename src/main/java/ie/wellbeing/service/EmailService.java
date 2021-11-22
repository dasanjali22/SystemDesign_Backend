package ie.wellbeing.service;

import ie.wellbeing.model.Booking;

public interface EmailService {

    void sendSimpleMessage(Booking booking) throws Exception;
}
