package ie.wellbeing.security;

import ie.wellbeing.model.UserRegistration;
import ie.wellbeing.repository.UserDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class JwtCustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserRegistration userRegistration = userDetailsDao.findByEmail(username);
        if (userRegistration != null) {
            return new User(userRegistration.getEmail(), userRegistration.getConfirmPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }
    }
}
