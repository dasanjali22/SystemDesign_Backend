// package ie.wellbeing.controller;
// import ie.wellbeing.common.ApiResponse;
// import ie.wellbeing.request.UserRequest;
// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.mock.web.MockHttpServletRequest;
// import org.springframework.web.context.request.RequestContextHolder;
// import org.springframework.web.context.request.ServletRequestAttributes;

// import java.io.IOException;

// public class UserControllerTest {

//     private UserController userController;

//     private UserRequest userRequest;

//     @BeforeEach
//     public void setUp(){
//         MockHttpServletRequest request = new MockHttpServletRequest();
//         RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//         userController = new UserController();
//         userRequest = new UserRequest();
//     }

//     @Test
//     public void  createUserRegistration() throws IOException {
//         userRequest = createUserDetails();
//       //  ApiResponse responseStatus = userController.createUserRegistration(userRequest);
//        // Assertions.assertEquals(responseStatus.getStatus(), 0);
//     }

//     private UserRequest createUserDetails(){
//         userRequest.setuName("Test");
//         userRequest.setuEmail("test@gmail.com");
//         userRequest.setuPhone(123456789);
//         return userRequest;
//     }




// }
