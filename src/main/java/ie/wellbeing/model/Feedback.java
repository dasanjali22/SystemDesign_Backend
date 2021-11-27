package ie.wellbeing.model;

import javax.persistence.*;

@Table(name= "feedback")
@Entity
public class Feedback
{
    @Id
    @SequenceGenerator(
            name="feedback_sequence",
            sequenceName="feedback_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="feedback_sequence"
    )
    @Column(name = "feedback_Id")
    private Integer id;


    @Column(name = "comment")
    public String comment;

    @Column(name = "rating")
    public double rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
