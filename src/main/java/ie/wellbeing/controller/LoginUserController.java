package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.request.LoginRequest;
import ie.wellbeing.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loginUser")
public class LoginUserController {
    @Autowired
    private LoginService loginService;



    @PostMapping("/login")
    public ApiResponse loginUser(@RequestBody LoginRequest loginRequest, HttpServletRequest request)  throws IOException, MessagingException {
        loginService.loginUser(loginRequest, getSiteURL(request));
        return ApiResponseBuilder.success().build();
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

}