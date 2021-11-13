package ie.wellbeing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;


@Component
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
   // private UserDetails userDetails;

    public void sendSimpleMessage() throws MessagingException, UnsupportedEncodingException {
        String toAddress = "wellbeingsystem123@gmail.com";
        String fromAddress = "wellbeingsystem123@gmail.com";
        String senderName = "Booking sys";
        String subject = "Booking Done!!!";
        String content = "Dear [[name]],<br>" +
                "please find booking details below";


        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        //content = content.replace("[[name]]", userDetails.getName());

        helper.setText(content, true);



        emailSender.send(message);

    }
}


