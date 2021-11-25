package ie.wellbeing.service.impl;

import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.model.Role;
import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.RoleDao;
import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.request.MembershipRequest;
import ie.wellbeing.request.RoleRequest;
import ie.wellbeing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public void updateRole(Integer userId, String type) {
        Role role = new Role();
        role.setuRole(type);
        role.setId(userId);
        roleDao.save(role);
    }

    @Override
    public List<UserRegistration> getAllUsers() {
        return userDetailsDao.findAll();
    }

}