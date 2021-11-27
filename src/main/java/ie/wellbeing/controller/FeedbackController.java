package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.model.Feedback;
import ie.wellbeing.request.FeedbackRequest;
import ie.wellbeing.service.FeedbackService;
import ie.wellbeing.service.impl.FeedbackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/setFeedback")
    public ApiResponse createFeedbackRequest(@RequestBody FeedbackRequest feedbackRequest) throws IOException, MessagingException {
        feedbackService.getFeedback(feedbackRequest);
        return ApiResponseBuilder.success().build();
    }

    @GetMapping("/getFeedback")
    public ApiResponse getAllFeedback() {
        return ApiResponseBuilder.success().data(feedbackService.getAllFeedback()).build();
    }

//    @GetMapping("/all")
//    public List<Feedback> getAllFeedback () {
//        return feedbackService.getAllFeedback();
//    }

    }

