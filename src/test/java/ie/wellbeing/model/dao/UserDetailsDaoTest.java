//package ie.wellbeing.model.dao;
//
//import ie.wellbeing.model.UserDetails;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//class UserDetailsDaoTest {
//
//    @Autowired
//    private UserDetailsDao userDetailsDao;
//
//    @Test
//    public void checkIfEmailExists(){
//        String email_is="anushkachalla@gmail.com";
//        UserDetails userDetails=new UserDetails(email_is);
//        userDetails.setEmail(email_is);
//        userDetailsDao.save(userDetails);
//
//        String expectedDetails = String.valueOf(userDetailsDao.findByEmail(email_is).getEmail());
//        assertEquals(email_is,expectedDetails);
//        //System.out.println(email_is+" "+"is verified with: "+" "+expectedDetails);
//    }
//}