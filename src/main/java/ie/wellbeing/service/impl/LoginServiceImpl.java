package ie.wellbeing.service.impl;
import ie.wellbeing.model.UserDetails;
import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.request.LoginRequest;
import ie.wellbeing.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service @RequiredArgsConstructor @Transactional @Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDetailsDao userDetailsDao;
    private PasswordEncoder passwordEncoder;

    public UserDetails loginUser(LoginRequest loginRequest, String siteURL) throws IllegalStateException {
        passwordEncoder = new BCryptPasswordEncoder();
        if (loginRequest.getuEmail() != null && loginRequest.getuConfirmPassword() != null) {
            UserDetails userDetails = userDetailsDao.findByEmail(loginRequest.getuEmail());
            boolean isPasswordMatches = passwordEncoder.matches(loginRequest.getuConfirmPassword(),userDetails.getConfirmPassword());
            if (isPasswordMatches) {
                System.out.println("Logged in");
                return  userDetails;
            } else{
                throw new IllegalStateException("Password Mismatch");
            }
        }  else{
            throw new IllegalStateException("User Not registered please Register");
        }
    }

}
