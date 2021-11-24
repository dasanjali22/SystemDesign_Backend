//package ie.wellbeing.model.dao;
//
//
//import com.sun.tools.javac.util.List;
//import ie.wellbeing.model.Role;
//import ie.wellbeing.repository.RoleDao;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(value = false)
//
//public interface RoleDaoTest {
//    @Autowired
//    RoleDao roleDao = null;
//
//    @Test
//    public default void testCreateRole(){
//        Role user = new Role("User");
//        Role admin = new Role("Admin");
//
//        roleDao.saveAll(List.of(user,admin));
//       java.util.List<Role> listRoles = roleDao.findAll();
//
//    }
//}
