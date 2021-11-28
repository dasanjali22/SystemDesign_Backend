package ie.wellbeing.service;

import ie.wellbeing.model.Feedback;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface FeedbackService {
    Feedback getFeedback(ie.wellbeing.DTO.FeedbackRequestDto feedbackRequestDto)throws MessagingException, UnsupportedEncodingException;
    List<Feedback> getAllFeedback();

}
