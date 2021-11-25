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
    private String employeeName;

    @Column(name = "employee_type")
    private String eType;

    @Column(name = "employee_email")
    private String eEmail;

    public Integer getId() {
        return eId;
    }

    public void setId(Integer id) {
        this.eId = eId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String geteType() {
        return eType;
    }

    public void seteType(String eType) {
        this.eType = eType;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteEmail() {
        return eEmail;
    }

    public void seteEmail(String eEmail) {
        this.eEmail = eEmail;
    }
}
