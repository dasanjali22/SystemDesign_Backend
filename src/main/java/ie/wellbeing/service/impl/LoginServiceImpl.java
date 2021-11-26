package ie.wellbeing.service.impl;
import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.UserRegistrationRepo;
import ie.wellbeing.DTO.LoginRequestDto;
import ie.wellbeing.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRegistrationRepo userRegistrationRepo;
    private PasswordEncoder passwordEncoder;

    public UserRegistration loginUser(LoginRequestDto loginRequestDto, String siteURL) throws IllegalStateException {
        passwordEncoder = new BCryptPasswordEncoder();
        if (loginRequestDto.getuEmail() != null && loginRequestDto.getuConfirmPassword() != null) {
            UserRegistration userRegistration = userRegistrationRepo.findByEmail(loginRequestDto.getuEmail());
            boolean isPasswordMatches = passwordEncoder.matches(loginRequestDto.getuConfirmPassword(), userRegistration.getConfirmPassword());
            if (isPasswordMatches) {
                System.out.println("Logged in");
                return userRegistration;
            } else{
                throw new IllegalStateException("Password Mismatch");
            }
        }  else{
            throw new IllegalStateException("User Not registered please Register");
        }
    }
}
