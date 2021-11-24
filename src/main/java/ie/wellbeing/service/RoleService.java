package ie.wellbeing.service;
import java.util.List;
import ie.wellbeing.model.Role;
import ie.wellbeing.model.UserDetails;


public interface RoleService {
      void updateRole(Integer userId, String type);
      List<UserDetails> getAllUsers();
}
