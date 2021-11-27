package ie.wellbeing.service;

import ie.wellbeing.model.Feedback;
import ie.wellbeing.request.FeedbackRequest;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface FeedbackService {
    Feedback getFeedback(FeedbackRequest feedbackRequest)throws MessagingException, UnsupportedEncodingException;
    List<Feedback> getAllFeedback();

}
