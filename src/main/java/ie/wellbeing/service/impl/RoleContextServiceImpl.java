package ie.wellbeing.service.impl;

import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.service.RoleContextService;
import ie.wellbeing.service.RoleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class RoleContextServiceImpl implements RoleContextService {

    private RoleState roleState;

    @Autowired
    UserDetailsDao userDetailsDao;

    public RoleContextServiceImpl() {
        roleState = new RoleMembershipImpl(this);
    }

    @Override
    public void changeStateTo(RoleState newState, Long userId){
        UserRegistration userDetails=userDetailsDao.getById(userId);
        userDetails.setmName(newState.roleName());
        userDetailsDao.save(userDetails);
    }

    @Override
    public String handle(){
        return this.roleState.roleName();
    }
}