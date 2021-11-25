package ie.wellbeing.service;


public interface MembershipContextService {

    public void changeStateTo(MembershipState newState, Long userId);
    public String handle();
}
