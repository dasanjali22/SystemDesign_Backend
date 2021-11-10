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

    public void sendSimpleMessage() throws MessagingException, UnsupportedEncodingException {
        String toAddress = "wellbeingsystem123@gmail.com";
        String fromAddress = "wellbeingsystem123@gmail.com";
        String senderName = "Booking sys";
        String subject = "Booking Done!!!";
        String content = "userId: 1, sessionId: 112, bookingId: 2,bookingType: doctor,sessionTime: 22-11-2021 10:15:55 AM";


        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        helper.setText(content, true);

        emailSender.send(message);

    }
}


