package ie.wellbeing.service;

import ie.wellbeing.model.LoginUser;
import ie.wellbeing.repository.LoginUserDao;
import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthenticationService {
    @Autowired
    private LoginUserDao loginUserDao;


    @Autowired
    private UserDetailsDao userDetailsDao;

    public String authenticateUser(LoginRequest loginRequest) {
        // TODO Auto-generated method stub

        LoginUser result = userDetailsDao.findByEmailAndConfirmPassword(loginRequest.getuEmail(),loginRequest.getuConfirmPassword());
        if (result!= null)
            return "Success";
        else
            return "Invalid Credentials";

    }

    public User GetUserbyemail(String email){
      ie.wellbeing.model.UserDetails  userDetails = userDetailsDao.getUserByEmail(email);
        UserDetails springUser = null;
        if (userDetails != null) {
            ArrayList<GrantedAuthority> newAuthorities = new ArrayList<>();
//            if(userdetails.getIsAdmin())
//            {
//                newAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
//            }
            springUser = new User(userDetails.getEmail(),userDetails.getConfirmPassword(),newAuthorities);
        }
        else {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
        }
        return (User) springUser;
    }

}
