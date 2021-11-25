package ie.wellbeing.request;

import ie.wellbeing.model.Booking;

public class BookingResponse {

    public Booking booking;
    public String paymentUrl;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    @Override
    public String toString() {
        return "BookingResponse{" +
                "booking=" + booking +
                ", paymentUrl='" + paymentUrl + '\'' +
                '}';
    }
}
