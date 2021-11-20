package ie.wellbeing.service.impl;


import ie.wellbeing.model.LoginUser;
import ie.wellbeing.model.UserDetails;
import ie.wellbeing.model.UserRole;
import ie.wellbeing.model.dao.LoginUserDao;
import ie.wellbeing.model.dao.UserDetailsDao;
import ie.wellbeing.model.dao.UserRoleDao;
import ie.wellbeing.request.LoginRequest;
import ie.wellbeing.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDetailsDao userDetailsDao;
    private  LoginUserDao loginUserDao;
    private  UserRoleDao userRoleDao;
    private UserRole role;


    public void loginUser(LoginRequest loginRequest, String siteURL) throws IllegalStateException {
        BCryptPasswordEncoder passwordDecoder = new BCryptPasswordEncoder();
//        String checkPassword = String.valueOf(userDetailsDao.findByConfirmPassword(loginRequest.getuConfirmPassword()));

        if (loginRequest.getuEmail() != null) {
            UserDetails userDetails = userDetailsDao.findByEmail(loginRequest.getuEmail());
            if (userDetails!=null) {
//                boolean isPasswordMatch = passwordDecoder.matches(loginRequest.getuConfirmPassword(),checkPassword);
                System.out.println("Successfully");
//                if(loginRequest.getuConfirmPassword().equals(userDetailsDao.findByConfirmPassword(loginRequest.getuConfirmPassword()))){
//                    System.out.println("Successfully");
//                }
            } else {
                throw new IllegalStateException("Bad Credentials");
            }
        } else {
            throw new IllegalStateException("Fields cannot be empty");
        }
    }

    @Override
    public LoginUser saveUser(LoginUser lUser) {
//        log.info("Saving new user{} to the database", lUser.getName());
        return loginUserDao.save(lUser);
    }

    @Override
    public UserRole saveRole(UserRole uRole) {
//        log.info("Saving new role{} to the database",role.getName());
        return userRoleDao.save(uRole);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
//        log.info("Adding role{} to user{}",roleName,userName);
        LoginUser loginUser = loginUserDao.findByEmail(userName);
        UserRole userRole = (UserRole) userRoleDao.findByName(roleName);
//        loginUser.getRoles().add(role);
    }

    @Override
    public LoginUser getLoginUser(String userName) {
//        log.info("Fetching user{}",userName);
        return  loginUserDao.findByEmail(userName);
    }

    @Override
    public List<LoginUser> getAllUsers() {
//        log.info("Fetching all users");
        return loginUserDao.findAll();
    }
}
