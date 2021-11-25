package ie.wellbeing.service;

import ie.wellbeing.model.LoginUser;
import ie.wellbeing.model.UserDetails;
import ie.wellbeing.request.LoginRequest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;


public interface LoginService {
   UserDetails loginUser(LoginRequest loginRequest, String siteURL) throws MessagingException, UnsupportedEncodingException;
}
