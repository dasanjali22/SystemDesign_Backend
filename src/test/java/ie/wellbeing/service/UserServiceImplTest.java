<<<<<<< HEAD
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
=======
package ie.wellbeing.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest {

>>>>>>> 0f143d25ebb66a6241f656fd4c0a87fc1974ed3d
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
<<<<<<< HEAD
//
//    private User createUserDetails(){
//        user.setUphone(123456789);
//        user.setUemail("test@gmail.com");
//        user.setUname("test");
//        return user;
//    }
//}
=======
    @Test
    public void registrationUserTest(){

    }
}
>>>>>>> 0f143d25ebb66a6241f656fd4c0a87fc1974ed3d
