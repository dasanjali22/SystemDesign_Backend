package ie.wellbeing.service;

import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.DTO.LoginRequestDto;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;


public interface LoginService {
   UserRegistration loginUser(LoginRequestDto loginRequestDto, String siteURL) throws MessagingException, UnsupportedEncodingException;
}
