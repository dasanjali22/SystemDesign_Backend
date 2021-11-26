package ie.wellbeing.service.impl;

import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.UserRegistrationRepo;
import ie.wellbeing.service.MembershipContextService;
import ie.wellbeing.service.MembershipState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipContextServiceImpl implements MembershipContextService {

    private MembershipState membershipState;

    @Autowired
    UserRegistrationRepo userRegistrationRepo;

    public MembershipContextServiceImpl(){
        membershipState = new NoMembershipServiceImpl(this   );
    }

    @Override
    public void changeStateTo(MembershipState newState, Long userId){
        UserRegistration userRegistration = userRegistrationRepo.getById(userId);
        userRegistration.setmName(newState.membershipName());
        userRegistrationRepo.save(userRegistration);
    }

    @Override
    public String handle(){
        return this.membershipState.membershipName();
    }

}
