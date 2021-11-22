package ie.wellbeing.service.impl;

import ie.wellbeing.repository.UserDetailsDao;
import ie.wellbeing.request.LoginRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private UserDetailsDao userDetailsDao;
    private LoginRequest loginRequest;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.equals("anjalids916")){
            return new User( "anjalids916","abcdefgh",new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
