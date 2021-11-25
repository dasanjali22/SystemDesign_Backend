package ie.wellbeing.service.impl;

import ie.wellbeing.service.MembershipState;


public class SilverMembershipServiceImpl extends MembershipState {

    @Override
    public String membershipName() {
        return "SILVER";
    }

    @Override
    public Integer membershipId() {
        return 3;
    }

    @Override
    public Integer membershipPrice() {
        return 99;
    }

}
