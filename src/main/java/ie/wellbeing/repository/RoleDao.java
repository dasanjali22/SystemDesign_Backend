package ie.wellbeing.repository;

import ie.wellbeing.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleDao extends JpaRepository<Role,Integer> {
//    Role getRoleByuId(Integer userId);
}
