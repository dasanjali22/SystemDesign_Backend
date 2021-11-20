package ie.wellbeing.controller;

import ie.wellbeing.common.Response;
import ie.wellbeing.model.PaymentDetails;
import ie.wellbeing.service.PaymentService;
import ie.wellbeing.service.PaymentStripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("payment-stripe")
public class PaymentStripeController {

    @Value("${stripe.key.public}")
    private String API_PUBLIC_KEY;

    @Autowired
    private PaymentStripeService paymentStripeService;

    @Autowired
    PaymentService paymentService;

    @GetMapping("/charge")
    public String chargePage(Model model) {
        model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
        return "charge";
    }

    @PostMapping("/create-charge")
    public @ResponseBody Response createCharge(String email, String token ) {

        if (token == null) {
            return new Response(false, "Stripe payment token is missing. please try again later.");
        }
        PaymentDetails paymentDetails = paymentService.checkUserPaymentId(email);
        int price = paymentDetails.getPaymentPrice();

        String chargeId = paymentStripeService.createCharge(email, token, price*100);
        if (chargeId == null) {
            return new Response(false, "An error accurred while trying to charge.");
        }
        if (chargeId != null) {
            paymentService.updatePaymentDetails(paymentDetails);
        }
        return new Response(true, "Success your charge id is " + chargeId);
    }
}