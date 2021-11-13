package ie.wellbeing.service.impl;

import ie.wellbeing.model.UserDetails;
import ie.wellbeing.model.dao.UserDetailsDao;
import ie.wellbeing.request.UserRequest;
import ie.wellbeing.service.MembershipContextService;
import ie.wellbeing.service.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDetailsDao userDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    MembershipContextService membershipService;


    @Override
    public void registrationUser(UserRequest userRequest,String siteURL) throws IllegalStateException, MessagingException, UnsupportedEncodingException {
        passwordEncoder=new BCryptPasswordEncoder();
        UserDetails userOptional = userDao.findByEmail(userRequest.getuEmail());
        if (userOptional==null) {
            String randomCode = RandomString.make(64);
            UserDetails userdetails = new UserDetails();
            userdetails.setName(userRequest.getuName());
            userdetails.setEmail(userRequest.getuEmail().toLowerCase());
            userdetails.setPhone(userRequest.getuPhone());
            userdetails.setAge(userRequest.getuAge());
            userdetails.setCity(userRequest.getuCity());
            userdetails.setCountry(userRequest.getuCountry());
            userdetails.setVerificationCode(randomCode);
            userdetails.setEnabled(false);
            userdetails.setmName(membershipService.handle());
            if(userRequest.getuCreatePassword().equals(userRequest.getuConfirmPassword())){
                String encodedPassword=this.passwordEncoder.encode(userRequest.getuConfirmPassword());
                userdetails.setConfirmPassword(encodedPassword);
                userdetails.setCreatePassword(encodedPassword);
            }
            else{
                throw new IllegalStateException("Password Mismatch");
            }
            userDao.save(userdetails);
            sendVerificationEmail(userdetails, siteURL);
        }
        else{
            throw new IllegalStateException("User Already registered please login: "+ userOptional.getEmail());
        }
    }

    @Override
    public List<UserDetails> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public boolean verify(String verificationCode){
        UserDetails userDetails = userDao.findByVerificationCode(verificationCode);
        if (userDetails == null || userDetails.isEnabled()) {
            return false;
        } else {
            userDetails.setVerificationCode(null);
            userDetails.setEnabled(true);
            userDao.save(userDetails);
            return true;
        }
    }

    public  void sendVerificationEmail(UserDetails userDetails, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = userDetails.getEmail();
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

        content = content.replace("[[name]]", userDetails.getName());
        String verifyURL = siteURL + "/user/verify/" + userDetails.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }
}
