package ie.wellbeing.service;

public interface RoleContextService {
    public void changeStateTo(RoleState newState, Long userId);
    public String handle();
}