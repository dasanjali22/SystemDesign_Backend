//package ie.wellbeing.service.impl;
//
//import ie.wellbeing.helper.UserPrincipal;
//import ie.wellbeing.repository.UserDetailsDao;
//import ie.wellbeing.request.LoginRequest;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//
//    private UserDetailsDao userDetailsDao;
//    private LoginRequest loginRequest;
//
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        ie.wellbeing.model.UserDetails user = userDetailsDao.findByEmail(loginRequest.getuEmail());
////
////        if (!user.isPresent()) {
////            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
////        }
////
//        return UserPrincipal.create(user.get());
//}
