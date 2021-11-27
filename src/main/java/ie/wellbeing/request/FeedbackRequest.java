package ie.wellbeing.request;

public class FeedbackRequest {

    private Integer id;

    public String comment;

    public Double rating;

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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "FeedbackRequest{" +
                "Feedback Id='" + id + '\'' +
                ", comment='" + comment + '\'' +
                ", rating=" + rating + '\'' +"}";
    }
}
