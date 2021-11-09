package ie.wellbeing.model;

import javax.persistence.*;

@Entity
@Table(name = "paymentdetails")
public class PaymentDetails {

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
    @Column(name = "payment_Id")
    private Integer id;

    @Column(name = "payment_user_id")
    private Integer paymentUserId;

    @Column(name = "payment_date")
    private String paymentDate;

    @Column(name = "payment_price")
    private Integer paymentPrice;

    @Column(name = "payment_status")
    private Integer paymentStatus;

    @Column(name = "payment_type")
    private String paymentType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaymentUserId() {
        return paymentUserId;
    }

    public void setPaymentUserId(Integer paymentUserId) {
        this.paymentUserId = paymentUserId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(Integer paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
