package ie.wellbeing.model;


import javax.persistence.*;

/*
Authors : Sai Rohit Voleti & Subhiksha
 */
@Table(name = "BOOKING_TABLE")
@Entity
public class Booking{

    @Id
    @SequenceGenerator(
            name="booking_sequence",
            sequenceName="booking_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="booking_sequence"
    )
    @Column(name = "BID")
    private Integer bookingId;

    @Column(name = "employee_id")
    private Integer eId;

    @Column(name = "UID")
    private Long userId;

    @Column(name = "Btype")
    private String bookingType;

    @Column(name = "stime")
    private String sessionSlot;

    @Column(name = "sPrice")
    private Integer servicePrice;

    @Column(name = "payment_status")
    private Integer paymentStatus;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
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

    public Integer getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Integer servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
