package ie.wellbeing.service.impl;

import ie.wellbeing.model.UserDetails;
import ie.wellbeing.model.dao.UserDetailsDao;
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
    public void changeStateTo(MembershipState newState, Integer userId){
        UserDetails userDetails=userDetailsDao.getById(userId);
        userDetails.setmName(newState.membershipName());
        userDetailsDao.save(userDetails);
    }

    @Override
    public String handle(){
        return this.membershipState.membershipName();
    }

}
