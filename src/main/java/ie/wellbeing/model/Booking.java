package ie.wellbeing.model;


import javax.persistence.*;
import java.util.Date;


/*
Authors : Sai Rohit Voleti & Subhiksha
 */
@Table(name = "BOOKING_TABLE")
@Entity
public class Booking{

    @Id
    @SequenceGenerator(
            name="payment_sequence",
            sequenceName="payment_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="payment_sequence"
    )

    @Column(name = "UID")
    private Integer userId;
    @Column(name = "SID")
    private Integer sessionId;
    @Column(name = "BID")
    private Integer bookingId;
    @Column(name = "Btype")
    private String bookingType;
    @Column(name = "stime")
    private Date sessionTime;



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
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

    public Date getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Date sessionTime) {
        this.sessionTime = sessionTime;
    }

}
