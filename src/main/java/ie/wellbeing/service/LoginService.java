package ie.wellbeing.service;

import ie.wellbeing.request.LoginRequest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;


public interface LoginService {
   void loginUser(LoginRequest loginRequest, String siteURL) throws MessagingException, UnsupportedEncodingException;

}
