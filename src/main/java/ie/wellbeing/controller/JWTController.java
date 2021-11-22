package ie.wellbeing.controller;

import ie.wellbeing.helper.JwtUtil;
import ie.wellbeing.request.JwtRequest;
import ie.wellbeing.request.JwtResponse;
import ie.wellbeing.model.UserDetails;
import ie.wellbeing.service.impl.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class JWTController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/token",method = POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println(jwtRequest);
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        } catch(UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Bad Credential");
        }
        UserDetails userDetails = (UserDetails) this.customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken((org.springframework.security.core.userdetails.UserDetails) userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
