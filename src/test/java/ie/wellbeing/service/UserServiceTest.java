package ie.wellbeing.service;

import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.UserRegistrationRepo;
import ie.wellbeing.service.impl.UserRegistrationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private MembershipContextService membershipService;

    @Mock
    private MimeMessageHelper mimeMessageHelper;

    @Mock
    private MimeMessage mimeMessage;

    @Mock
    private UserRegistrationRepo userDetailsDao;

    @InjectMocks
    private UserRegistrationService userService = new UserRegistrationServiceImpl();

    @Mock
    private JavaMailSender mailSender;

    @BeforeEach
    public void setup() throws MessagingException, UnsupportedEncodingException {
        mimeMessageHelper.setFrom("anjali","anushka");
        mimeMessageHelper.setTo("anjali");
        mimeMessageHelper.setSubject("abc");
        mimeMessage.setFrom();
        mimeMessage.saveChanges();
    }

//    @Test
//    void registrationUser() throws MessagingException, UnsupportedEncodingException {
//        UserRequest userRequest = new UserRequest();
//        String siteUrl = "Test";
//        userRequest.setuEmail("anjalids916@gmail.com");
//        userRequest.setuAge(25);
//        userRequest.setuCity("Pune");
//        userRequest.setuCountry("India");
//        userRequest.setuName("Anjali");
//        userRequest.setuCreatePassword("abcdefgh");
//        userRequest.setuConfirmPassword("abcdefgh");
//        userRequest.setuPhone(987654321);
//        userService.registrationUser(userRequest,siteUrl);
//    }

    @Test
    void getAllUsers() {
        List<UserRegistration> result = userService.getAllUsers();
    }

    @Test
    void verify() {
        boolean result = userService.verify("abcdefghknkn");
    }

    @Test
    void verifyTest() {
        boolean result = userService.verify("http://localhost:8080/user/verify/QbZAZia29ybdtU1dubLW8z5zGXIwiORkgTrkmNBSTqU6L1C7bswfa3oBD9wgYxjj");
    }
}