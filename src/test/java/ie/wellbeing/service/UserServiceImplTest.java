//package ie.wellbeing.service;
//
//import ie.wellbeing.model.dao.UserDao;
//import ie.wellbeing.service.impl.UserServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//public class UserServiceImplTest {
//
//    private UserServiceImpl userService;
//
//    private UserDao userDao;
//
//    private User user;
//
//
//    @BeforeEach
//    public void setUp(){
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//        userService = new UserServiceImpl();
//        user = new User();
//    }
//
//    @Test
//    public void saveUserDetails(){
//        user = createUserDetails();
//        userDao.save(user);
//    }
//
//    private User createUserDetails(){
//        user.setUphone(123456789);
//        user.setUemail("test@gmail.com");
//        user.setUname("test");
//        return user;
//    }
//}
