package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.service.RoleService;
import ie.wellbeing.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRegistrationService userService;


    @GetMapping("/getAllUserDetails")
    public ApiResponse getAllUserDetails() {
        return ApiResponseBuilder.success().data(userService.getAllUsers()).build();
    }

}