package ie.wellbeing.service;

import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.request.LoginRequest;
import ie.wellbeing.service.impl.LoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public class LoginServiceTest {

    @InjectMocks
    private LoginService loginService = new LoginServiceImpl();

    @Mock
    private UserDetailsDao userDao;

//    @Test
//    void loginUser() throws MessagingException, UnsupportedEncodingException {
//        LoginRequest loginRequest = new LoginRequest();
//        String siteUrl = "Test";
//        loginRequest.setuEmail("anjalids916@gmail.com");
//        loginRequest.setuConfirmPassword("abcdefh");
//        loginService.loginUser(loginRequest,siteUrl);
//    }
}
