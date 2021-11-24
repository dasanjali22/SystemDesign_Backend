package ie.wellbeing.service;

public interface RoleContextService {
    public void changeStateTo(RoleState newState, Integer userId);
    public String handle();
}
