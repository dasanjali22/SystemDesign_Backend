package ie.wellbeing.model;


import javax.persistence.*;

@Entity
@Table(name = "membershipdetails")
public class MembershipDetails {

    @Id
    @SequenceGenerator(
            name="membership_sequence",
            sequenceName="membership_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="membership_sequence"
    )

    @Column(name = "membership_Details_Id")
    private Integer id;

    @Column(name = "membership_Name")
    private String mName;

    @Column(name = "UID")
    private Integer uId;

    @Column(name = "membership_Start_Date")
    private String mStartDate;

    @Column(name = "membership_End_Date")
    private String mEndDate;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmStartDate() {
        return mStartDate;
    }

    public void setmStartDate(String mStartDate) {
        this.mStartDate = mStartDate;
    }

    public String getmEndDate() {
        return mEndDate;
    }

    public void setmEndDate(String mEndDate) {
        this.mEndDate = mEndDate;
    }
}
