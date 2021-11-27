package ie.wellbeing.service;

import ie.wellbeing.DTO.LoginRequestDto;
import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.UserRegistrationRepo;
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
 class LoginServiceTest {

    @InjectMocks
    private LoginService loginService = new LoginServiceImpl();

    @Mock
    private UserRegistrationRepo userDao;

    @Mock
    private UserRegistration userRegistration;

    @Test
    void loginUser() throws MessagingException, UnsupportedEncodingException {
        LoginRequestDto loginRequest = new LoginRequestDto();
        UserRegistration userRegistration = new UserRegistration();
        String siteUrl = "Test";
        loginRequest.setuEmail("anjalids916@gmail.com");
        loginRequest.setuConfirmPassword("abcdefh");
        userRegistration.getConfirmPassword();
//        loginService.loginUser(loginRequest,siteUrl);
    }
}
