package ie.wellbeing.service.impl;

<<<<<<< HEAD
import ie.wellbeing.model.dao.MembershipDao;
import ie.wellbeing.service.MembershipServiceState;
import org.springframework.beans.factory.annotation.Autowired;
=======
import ie.wellbeing.service.MembershipState;
>>>>>>> 2469c845f5be36f80155aeae4dd7995b42e25f78

public class PlatinumMembershipServiceImpl extends MembershipState {

    @Override
    public String membershipName() {
        return "PLATINUM";
    }

    @Override
    public Integer membershipId() {
        return 1;
    }

    @Override
    public Integer membershipPrice() {
        return 199;
    }

}
