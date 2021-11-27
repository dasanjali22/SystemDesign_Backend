package ie.wellbeing.service;

import ie.wellbeing.model.Booking;
import ie.wellbeing.model.EmployeeDetails;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface ObserverUserService {

    void sendSimpleMessage(Booking booking) throws Exception;

}
