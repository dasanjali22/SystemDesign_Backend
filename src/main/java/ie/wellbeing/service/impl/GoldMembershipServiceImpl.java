package ie.wellbeing.service.impl;

import ie.wellbeing.service.MembershipState;
import org.springframework.beans.factory.annotation.Autowired;


public class GoldMembershipServiceImpl extends MembershipState {

    @Override
    public String membershipName() {
        return "GOLD";
    }

    @Override
    public Integer membershipId() {
        return 2;
    }

    @Override
    public Integer membershipPrice() {
        return 149;
    }

}
