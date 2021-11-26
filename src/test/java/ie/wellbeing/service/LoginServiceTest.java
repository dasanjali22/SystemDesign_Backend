package ie.wellbeing.service;

import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.request.LoginRequest;
import ie.wellbeing.service.impl.LoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    @InjectMocks
    private LoginService loginService = new LoginServiceImpl();

    @Mock
    private UserDetailsDao userDao;

    @Mock
    private UserRegistration userRegistration;

    @Test
    void loginUser() throws MessagingException, UnsupportedEncodingException {
        LoginRequest loginRequest = new LoginRequest();
        UserRegistration userRegistration = new UserRegistration();
        String siteUrl = "Test";
        loginRequest.setuEmail("anjalids916@gmail.com");
        loginRequest.setuConfirmPassword("abcdefh");
        userRegistration.getConfirmPassword();
//        loginService.loginUser(loginRequest,siteUrl);
    }
}
