package ie.wellbeing.controller;

import ie.wellbeing.exception.AuthenticateException;
import ie.wellbeing.security.JwtUtil;
import ie.wellbeing.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@CrossOrigin
public class JWTController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userdetailsservice;

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${jwt.http.request.header}")
    private String tokenHeader;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {
        // Authenticate the user throws exception if not able to authenticate
        authenticate(loginRequest.getuEmail(),loginRequest.getuConfirmPassword());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getuEmail(), loginRequest.getuConfirmPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username and password");
        }
        final UserDetails userDetails = userdetailsservice.loadUserByUsername(loginRequest.getuEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(jwt);
    }

    @ExceptionHandler({ AuthenticateException.class })
    public ResponseEntity<String> handleAuthenticationException(AuthenticateException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticateException("User Disabled",e);
        } catch (BadCredentialsException e) {
            throw new AuthenticateException("INVALID_CREDENTIALS", e);
        }
    }

}
