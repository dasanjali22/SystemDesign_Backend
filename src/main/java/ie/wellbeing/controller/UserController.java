package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.request.UserRequest;
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
    public ApiResponse createUserRegistration(@RequestBody UserRequest userRequest, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
           userRegistrationService.registrationUser(userRequest, getSiteURL(request));
           return ApiResponseBuilder.success().build();

    }

    private String getSiteURL(HttpServletRequest request) {

        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

<<<<<<< HEAD
=======
    @GetMapping("/getUsers")
    public ApiResponse getAllUsers() {
            return ApiResponseBuilder.success().data(userRegistrationService.getAllUsers()).build();

    }

>>>>>>> f4ddc09c0340052a2aa7772c9961ded607a6fab3
    @GetMapping("/verify/{code}")
    public String verifyUser(@PathVariable String code) {

        if (userRegistrationService.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }
}
