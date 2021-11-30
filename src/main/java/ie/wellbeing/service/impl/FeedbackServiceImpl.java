package ie.wellbeing.service.impl;


import ie.wellbeing.DTO.FeedbackRequestDto;
import ie.wellbeing.model.Feedback;

import ie.wellbeing.repository.FeedbackDao;
import ie.wellbeing.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {



    @Autowired
    private FeedbackDao feedbackDao;


    @Override
    public Feedback getFeedback(FeedbackRequestDto feedbackRequestDto) throws IllegalStateException, MessagingException, UnsupportedEncodingException {


          Feedback  feedback = new Feedback();
            feedback.setId(feedbackRequestDto.getId());
            feedback.setComment(feedbackRequestDto.getComment());
            feedback.setRating(feedbackRequestDto.getRating());


        feedbackDao.save(feedback);

        return feedback;
    }



    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackDao.findAll();
    }

}