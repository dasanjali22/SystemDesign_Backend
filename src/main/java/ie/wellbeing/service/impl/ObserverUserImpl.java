//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ie.wellbeing.service.impl;

import ie.wellbeing.model.Booking;
import ie.wellbeing.model.UserDetails;
import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.service.ObserverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class ObserverUserImpl implements ObserverUserService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserDetailsDao userDetailsDao;


    public ObserverUserImpl() {
    }

    @Override
    public void sendSimpleMessage(Booking booking) throws Exception {
        UserDetails userDetails = userDetailsDao.getById(booking.getUserId());

        if (userDetails==null) {
            throw new Exception("Invalid user Id");
        }
        else {
            String toAddress = userDetails.getEmail();
            String fromAddress = "uit13328@rmd.ac.in";
            String senderName = "Booking sys";
            String subject = "Booking Done!!!";
            String content = "Dear [[name]]," +
                    "<br>please find booking details below," +
                    " <br>booking id: [[bid]]" +
                    "<br>booking type: [[btype]]" +
                   // "<br>session id: [[sid]]" +
                    "<br>session Date: [[stime]]" +
                    "<br>Thanks for choosing our service";
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);
            content = content.replace("[[name]]", userDetails.getName());
            content = content.replace("[[bid]]", Integer.toString(booking.getBookingId()));
            content = content.replace("[[btype]]", booking.getBookingType());
           // content = content.replace("[[sid]]", Integer.toString(booking.getSessionId()));
            content = content.replace("[[stime]]", booking.getSessionSlot());
            helper.setText(content, true);
            mailSender.send(message);
        }

    }

}
