package ie.wellbeing.controller;

import ie.wellbeing.DTO.FeedbackRequestDto;
import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;


@RestController
@RequestMapping("feedback")
public class FeedbackController {


    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/setFeedback")
    public ApiResponse createFeedbackRequest(@RequestBody FeedbackRequestDto feedbackRequestDto) throws IOException, MessagingException {
        feedbackService.getFeedback(feedbackRequestDto);
        return ApiResponseBuilder.success().build();
    }

    @GetMapping("/getFeedback")
    public ApiResponse getAllFeedback() {
        return ApiResponseBuilder.success().data(feedbackService.getAllFeedback()).build();
    }



    }

