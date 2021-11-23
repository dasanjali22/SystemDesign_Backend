//package ie.wellbeing.service.impl;
//
//import ie.wellbeing.model.UserDetails;
//import ie.wellbeing.repository.UserDetailsDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CommonService {
//    @Autowired
//    private UserDetailsDao userDetailsDao;
//
//    public UserDetails Getloggedinuserdetails()
//    {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        org.springframework.security.core.userdetails.User jwtUser = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
//        UserDetails userdetails=userDetailsDao.GetUserbyemail(jwtUser.getUsername());
//        return userdetails;
//    }
//}
//
