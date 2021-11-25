package ie.wellbeing.service.impl;

import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.service.MembershipContextService;
import ie.wellbeing.service.MembershipState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembershipContextServiceImpl implements MembershipContextService {

    private MembershipState membershipState;

    @Autowired
    UserDetailsDao userDetailsDao;

    public MembershipContextServiceImpl(){
        membershipState = new NoMembershipServiceImpl(this   );
    }

    @Override
    public void changeStateTo(MembershipState newState, Long userId){
        UserRegistration userRegistration =userDetailsDao.getById(userId);
        userRegistration.setmName(newState.membershipName());
        userDetailsDao.save(userRegistration);
    }

    @Override
    public String handle(){
        return this.membershipState.membershipName();
    }

}
