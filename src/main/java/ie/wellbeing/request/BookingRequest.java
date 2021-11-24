package ie.wellbeing.request;

public class BookingRequest {

    private String eName;

    private Long userId;

    private String bookingType;

    private String sessionSlot;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getSessionSlot() {
        return sessionSlot;
    }

    public void setSessionSlot(String sessionSlot) {
        this.sessionSlot = sessionSlot;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "eName='" + eName + '\'' +
                ", userId=" + userId +
                ", bookingType='" + bookingType + '\'' +
                ", sessionSlot='" + sessionSlot + '\'' +
                '}';
    }
}
