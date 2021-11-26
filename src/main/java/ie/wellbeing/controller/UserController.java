package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.DTO.UserRequestDto;
import ie.wellbeing.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @PostMapping("/registerUser")
    public ApiResponse createUserRegistration(@RequestBody UserRequestDto userRequestDto, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
           return ApiResponseBuilder.success().data(userRegistrationService.registrationUser(userRequestDto, getSiteURL(request))).build();


    }

    private String getSiteURL(HttpServletRequest request) {

        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/verify/{code}")
    public String verifyUser(@PathVariable String code) {

        if (userRegistrationService.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }
}
