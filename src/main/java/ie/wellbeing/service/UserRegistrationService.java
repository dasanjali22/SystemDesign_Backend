package ie.wellbeing.service;


import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.DTO.UserRequestDto;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserRegistrationService {

    String registrationUser(UserRequestDto userRequestDto, String siteURL) throws MessagingException, UnsupportedEncodingException;

    List<UserRegistration> getAllUsers();

    boolean verify(String verificationCode);
}
