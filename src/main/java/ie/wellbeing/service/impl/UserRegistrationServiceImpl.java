package ie.wellbeing.service.impl;

import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.UserRegistrationRepo;
import ie.wellbeing.DTO.UserRequestDto;
import ie.wellbeing.service.MembershipContextService;
import ie.wellbeing.service.UserRegistrationService;
import ie.wellbeing.validator.UserValidator;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@PropertySource("application.properties")
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Value("${spring.user.already_exsist}")
    String errorRegister;

    @Value("${spring.user.password}")
    String wrongPassword;

    @Value("${spring.user.successRegister}")
    String successRegister;

    @Autowired
    MembershipContextService membershipService;

    @Autowired
    private UserRegistrationRepo userDao;

    @Autowired
    private JavaMailSender mailSender;

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserValidator userValidator;

    @Override
    public String registrationUser(UserRequestDto userRequestDto, String siteURL) throws IllegalStateException, UnsupportedEncodingException,MessagingException {
           passwordEncoder = new BCryptPasswordEncoder();
           String result=null;
           UserRegistration userOptional = userDao.findByEmail(userRequestDto.getuEmail());
           if (userOptional == null) {
               String randomCode = RandomString.make(64);
               UserRegistration userdetails = new UserRegistration();
               result=userValidator.validate(userRequestDto);
               if(result!=null){
                   return result;
               }
               userdetails.setName(userRequestDto.getuName());
               userdetails.setEmail(userRequestDto.getuEmail().toLowerCase());
               userdetails.setPhone(userRequestDto.getuPhone());
               userdetails.setAge(userRequestDto.getuAge());
               userdetails.setCity(userRequestDto.getuCity());
               userdetails.setCountry(userRequestDto.getuCountry());
               userdetails.setVerificationCode(randomCode);
               userdetails.setEnabled(false);
               userdetails.setmName(membershipService.handle());
               if (userRequestDto.getuCreatePassword().equals(userRequestDto.getuConfirmPassword())) {
                   String encodedPassword = this.passwordEncoder.encode(userRequestDto.getuConfirmPassword());
                   userdetails.setConfirmPassword(encodedPassword);
                   userdetails.setCreatePassword(encodedPassword);
               } else {
                   throw new IllegalStateException(wrongPassword);
               }
               userDao.save(userdetails);
               sendVerificationEmail(userdetails, siteURL);
           } else {
                return errorRegister;
               //throw new IllegalStateException("User Already registered please login: " + userOptional.getEmail());
           }
        return successRegister;
    }

    @Override
    public List<UserRegistration> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public boolean verify(String verificationCode) {
        UserRegistration userRegistration = userDao.findByVerificationCode(verificationCode);
        if (userRegistration == null || userRegistration.isEnabled()) {
            return false;
        } else {
            userRegistration.setVerificationCode(null);
            userRegistration.setEnabled(true);
            userDao.save(userRegistration);
            return true;
        }
    }

    public void sendVerificationEmail(UserRegistration userRegistration, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = userRegistration.getEmail();
        String fromAddress = "anushkachalla@gmail.com";
        String senderName = "Well-Being System";
        String subject = "Please verify your registration!!!";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", userRegistration.getName());
        String verifyURL = siteURL + "/user/verify/" + userRegistration.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }

}
