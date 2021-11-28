package ie.wellbeing.service;
import java.util.List;
import ie.wellbeing.model.Role;
import ie.wellbeing.model.UserRegistration;


public interface RoleService {
    void updateRole(Integer userId, String type);
    List<UserRegistration> getAllUsers();
}
