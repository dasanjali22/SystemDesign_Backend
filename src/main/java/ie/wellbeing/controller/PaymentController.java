package ie.wellbeing.controller;

import ie.wellbeing.common.ApiResponse;
import ie.wellbeing.common.ApiResponseBuilder;
import ie.wellbeing.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/getAllPayment")
    public ApiResponse getAllPayment() {
        return ApiResponseBuilder.success().data(paymentService.getAllPaymentDetails()).build();
    }


}
