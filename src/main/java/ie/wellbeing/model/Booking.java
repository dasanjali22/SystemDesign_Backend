
package ie.wellbeing.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Data
@Table(name = "booking")
@Entity
public class Booking{

    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "session_id")
    private Integer sessionId;
    @Column(name = "session_count")
    private Integer sessionCount;
    @Column(name = "session_type")
    private String sessionType;
    @Column(name = "session_time")
    private String sessionTime;

}
