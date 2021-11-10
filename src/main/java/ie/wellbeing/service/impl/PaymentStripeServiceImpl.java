package ie.wellbeing.service.impl;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import ie.wellbeing.service.PaymentStripeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentStripeServiceImpl implements PaymentStripeService {

    @Value("${stripe.key.secret}")
    private String API_SECRET_KEY;

    @Override
    public String createCharge(String email, String token, Integer amount) {
            String chargeId = null;
            try {
                Stripe.apiKey = API_SECRET_KEY;
                Map<String, Object> chargeParams = new HashMap<>();
                chargeParams.put("description","Charge for "+email);
                chargeParams.put("currency","eur");
                chargeParams.put("amount",amount);
                chargeParams.put("source",token);
                Charge charge = Charge.create(chargeParams);
                chargeId = charge.getId();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return chargeId;
        }
    }


