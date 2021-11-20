package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.model.UserRole;
import ie.wellbeing.request.LoginRequest;
import ie.wellbeing.service.LoginService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loginUser")
public class LoginUserController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/allUser")
        public ApiResponse getAllUsers() {
            return ApiResponseBuilder.success().data(loginService.getAllUsers()).build();
    }

//    @PostMapping("/loginUser")
//    public ApiResponse loginUser(@RequestBody LoginRequest loginRequest, HttpServletRequest request)  throws IOException, MessagingException {
//        loginService.loginUser(loginRequest, getSiteURL(request));
//        return ApiResponseBuilder.success().build();
//    }

    @PostMapping("/login")
    public ApiResponse loginUser(@RequestBody LoginRequest loginRequest, HttpServletRequest request)  throws IOException, MessagingException {
        loginService.loginUser(loginRequest, getSiteURL(request));
        return ApiResponseBuilder.success().build();
    }

//    public ResponseEntity<LoginUser>saveUser(@RequestBody LoginUser loginUser) {
////        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/loginUser/login").toUriString());
////        return ResponseEntity.created(uri).body(loginService.saveUser(loginUser));
//            loginService.loginUser(loginRequest, getSiteURL(request));
//            return ApiResponseBuilder.success().build();
//    }

    @PostMapping("/role/save")
    public ResponseEntity<UserRole>saveRole(@RequestBody UserRole userRole) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/loginUser/role/save").toUriString());
        return ResponseEntity.created(uri).body(loginService.saveRole(userRole));
    }

    @PostMapping("/role/addToUser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUseForm from) {
//        loginService.addRoleToUser(from.getUsername(),
//                from.getRoleName());
        return ResponseEntity.ok().build();
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @Data
    class RoleToUseForm {
        private String username;
        private String roleName;
    }


}