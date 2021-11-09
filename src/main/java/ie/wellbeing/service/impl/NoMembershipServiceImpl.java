package ie.wellbeing.service.impl;

<<<<<<< HEAD
import ie.wellbeing.service.MembershipServiceState;
=======
import ie.wellbeing.service.MembershipState;
>>>>>>> 2469c845f5be36f80155aeae4dd7995b42e25f78


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
