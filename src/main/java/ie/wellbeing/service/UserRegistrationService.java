package ie.wellbeing.service;


import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.request.UserRequest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserRegistrationService {

    void registrationUser(UserRequest userRequest, String siteURL) throws MessagingException, UnsupportedEncodingException;

    List<UserRegistration> getAllUsers();

    boolean verify(String verificationCode);
}
