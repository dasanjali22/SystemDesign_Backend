package ie.wellbeing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servicelist")
public class Service {

    @Id
    @Column(name = "service_Id")
    private Integer sId;

    @Column(name = "service_Name")
    private String serviceName;

    @Column(name = "service_Price")
    private Integer sPrice;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getsPrice() {
        return sPrice;
    }

    public void setsPrice(Integer sPrice) {
        this.sPrice = sPrice;
    }
}
