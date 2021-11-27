package ie.wellbeing.service.impl;


import ie.wellbeing.model.Booking;
import ie.wellbeing.model.EmployeeDetails;
import ie.wellbeing.model.UserDetails;
import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.service.ObserverEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class ObserverEmployeeImpl implements ObserverEmployeeService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserDetailsDao userDetailsDao;

public  ObserverEmployeeImpl() {
}



    public void sendSimpleMessage(EmployeeDetails employeeDetails, Booking booking) throws MessagingException, UnsupportedEncodingException {

        UserDetails userDetails = userDetailsDao.getById(booking.getUserId());
        String toAddress = employeeDetails.geteEmail();
        String fromAddress = "uit13328@rmd.ac.in";
        String senderName = "Booking sys";
        String subject = "You are booked for a session!!";
        String content = "Dear [[name]]," +
                "<br> You have been booked for a session.Please find the details below ," +
                "<br>Booking id: [[bid]]" +
                "<br>Session Date: [[sdate]]" +
                "<br>Customer Name: [[cname]]";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        content = content.replace("[[name]]", employeeDetails.getEmployeeName());
        content = content.replace("[[bid]]", Integer.toString(booking.getBookingId()));
       // content = content.replace("[[sid]]", Integer.toString(booking.getSessionId()));
        content = content.replace("[[sdate]]", booking.getSessionSlot());
        content = content.replace("[[cname]]", userDetails.getName());
        helper.setText(content, true);
        mailSender.send(message);
    }

    }