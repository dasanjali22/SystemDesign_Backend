package ie.wellbeing.service.impl;

import ie.wellbeing.service.MembershipState;
<<<<<<< HEAD

=======
>>>>>>> 0f143d25ebb66a6241f656fd4c0a87fc1974ed3d


public class NoMembershipServiceImpl extends MembershipState {

    private final MembershipContextServiceImpl membershipContextServiceImpl;

    public NoMembershipServiceImpl(MembershipContextServiceImpl membershipContextServiceImpl){
        this.membershipContextServiceImpl = membershipContextServiceImpl;
    }

    @Override
    public String membershipName() {
        //Set user membership initially to null
        return "NO_MEMBERSHIP";
    }

    @Override
    public Integer membershipId() {
        return 0;
    }

    @Override
    public Integer membershipPrice() {
        return 0;
    }

}
