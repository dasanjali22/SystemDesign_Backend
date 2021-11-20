package ie.wellbeing.service;

public interface PaymentStripeService {
    public String createCharge(String email, String token, Integer amount);
}
