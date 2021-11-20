package ie.wellbeing.model.dao;

import ie.wellbeing.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao extends JpaRepository<UserRole,Long> {
    UserRoleDao findByName(String name);
}
