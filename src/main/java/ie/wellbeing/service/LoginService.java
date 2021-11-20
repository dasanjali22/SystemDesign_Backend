package ie.wellbeing.service;

import ie.wellbeing.model.LoginUser;
import ie.wellbeing.model.UserRole;
import ie.wellbeing.request.LoginRequest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;


public interface LoginService {
   void loginUser(LoginRequest loginRequest, String siteURL) throws MessagingException, UnsupportedEncodingException;
   LoginUser saveUser(LoginUser lUser);
   UserRole saveRole(UserRole uRole);
   void addRoleToUser(String email,String roleName);
   LoginUser getLoginUser(String email);
   List<LoginUser>getAllUsers();
}
