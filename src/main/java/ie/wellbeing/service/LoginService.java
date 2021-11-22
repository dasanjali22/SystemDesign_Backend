package ie.wellbeing.service;

import ie.wellbeing.model.LoginUser;
import ie.wellbeing.request.LoginRequest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;


public interface LoginService {
   void loginUser(LoginRequest loginRequest, String siteURL) throws MessagingException, UnsupportedEncodingException;
}
