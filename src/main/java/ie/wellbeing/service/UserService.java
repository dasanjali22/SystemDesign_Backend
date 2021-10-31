/**
 * Project:Well-Being System
 * Creation Date: 22-10-21
 * Author: Sai Anushka
 * Package Created: Sai Anushka
 */

package ie.wellbeing.service;


import ie.wellbeing.model.UserDetails;
import ie.wellbeing.request.UserRequest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {

    void registrationUser(UserRequest userRequest, String siteURL) throws MessagingException, UnsupportedEncodingException;

    List<UserDetails> getAllUsers();

    boolean verify(String verificationCode);
}
