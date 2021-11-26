package ie.wellbeing.service.impl;

import ie.wellbeing.service.RoleState;

public class RoleMembershipImpl extends RoleState {

    private final RoleContextServiceImpl roleContextServiceImpl;


    public RoleMembershipImpl(RoleContextServiceImpl roleContextServiceImpl) {
        this.roleContextServiceImpl = roleContextServiceImpl;
    }

    @Override
    public String roleName() {
        //Set user role initially to null
        return "USER";
    }

    @Override
    public Integer roleId() {
        return 0;
    }
}
