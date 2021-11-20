package ie.wellbeing.service.impl;

import ie.wellbeing.service.MembershipState;

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
