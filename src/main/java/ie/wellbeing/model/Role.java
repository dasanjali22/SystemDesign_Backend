package ie.wellbeing.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name="role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 45)
    private String uRole;

    @Column(name = "UID")
    private Integer uId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Role() {
    }

    public Role(String uRole) {
        this.uRole = uRole;
    }

    public Role(long id) {
        this.id = id;
    }

    public Role(long id, String uRole) {
        this.id = id;
        this.uRole = uRole;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getuRole() {
        return uRole;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + uRole + '\'' +
                '}';
    }

    public void setuRole(String uRole) {
        this.uRole = uRole;
    }


}