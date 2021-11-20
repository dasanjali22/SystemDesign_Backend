package ie.wellbeing.service.impl;

import ie.wellbeing.service.MembershipState;


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
