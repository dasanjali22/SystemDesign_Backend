//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ie.wellbeing.service.impl;

import ie.wellbeing.model.Booking;
import ie.wellbeing.model.EmployeeDetails;
import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserDetailsDao userDetailsDao;

    public EmailServiceImpl() {
    }

    @Override
    public void sendSimpleMessage(Booking booking) throws Exception {
        UserRegistration userRegistration = userDetailsDao.getById(booking.getUserId());

        if (userRegistration ==null) {
            throw new Exception("Invalid user Id");
        }
        else {
            String toAddress = userRegistration.getEmail();
            String fromAddress = "uit13328@rmd.ac.in";
            String senderName = "Booking sys";
            String subject = "Booking Done!!!";
            String content = "Dear [[name]],<br>please find booking details below booking id [[bid]],<br>booking type [[btype]]session id [[sid]]session time [[stime]]thanks for choosing our service";
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);
            content = content.replace("[[name]]", userRegistration.getEmail());
            content = content.replace("[[bid]]", Integer.toString(booking.getBookingId()));
            content = content.replace("[[btype]]", booking.getBookingType());
           // content = content.replace("[[sid]]", Integer.toString(booking.getSessionId()));
            content = content.replace("[[stime]]", booking.getSessionSlot());
            helper.setText(content, true);
            mailSender.send(message);
        }
    }

    public void sendSimpleMessage(EmployeeDetails employeeDetails, Booking booking) throws MessagingException, UnsupportedEncodingException {
        String toAddress = "wellbeingsystem123@gmail.com";
        String fromAddress = "uit13328@rmd.ac.in";
        String senderName = "Booking sys";
        String subject = "You are booked for a session!!";
        String content = "Dear [[name]],<br>please find booking details belowemployee id [[eid]],<br>employee type [[btype]]session id [[sid]]session time [[stime]]thanks for choosing our service";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        content = content.replace("[[name]]", employeeDetails.getEmployeeName());
        content = content.replace("[[bid]]", Integer.toString(employeeDetails.getId()));
        content = content.replace("[[btype]]", employeeDetails.geteType());
       // content = content.replace("[[sid]]", Integer.toString(booking.getSessionId()));
        content = content.replace("[[stime]]", (new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")).format(booking.getSessionSlot()));
        helper.setText(content, true);
        mailSender.send(message);
    }
}
