package ie.wellbeing.service;

import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.request.LoginRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;


public interface LoginService {
   UserRegistration loginUser(LoginRequest loginRequest, String siteURL) throws MessagingException, UnsupportedEncodingException;
}
