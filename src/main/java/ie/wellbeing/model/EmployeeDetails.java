package ie.wellbeing.model;

import javax.persistence.*;

@Entity
@Table(name = "employeedetails")
public class EmployeeDetails {

    @Id
    @SequenceGenerator(
            name="employee_sequence",
            sequenceName="employee_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="employee_sequence"
    )

    @Column(name = "employee_id")
    private Integer eId;

    @Column(name = "employee_name")
    private String eName;

    @Column(name = "employee_type")
    private String eType;

    public Integer getId() {
        return eId;
    }

    public void setId(Integer id) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteType() {
        return eType;
    }

    public void seteType(String eType) {
        this.eType = eType;
    }
}
