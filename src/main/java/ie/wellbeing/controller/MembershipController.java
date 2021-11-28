/**
 * Project:Well-Being System
 * Creation Date: 22-10-21
 * Author: Sai Anushka
 * Package Created: Sai Anushka
 */

package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.DTO.MembershipRequestDto;
import ie.wellbeing.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("membership")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping("/createMembership")
    public String createUserMembership(@RequestBody MembershipRequestDto membershipRequestDto, HttpServletRequest request) throws Exception {
       String url= membershipService.createMembership(membershipRequestDto, getSiteURL(request));
        return url;
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/getMembershipDetails")
    public ApiResponse getAllUsersMembershipDetails() {
        return ApiResponseBuilder.success().data(membershipService.getAllUsersMembershipDetails()).build();
    }
}

