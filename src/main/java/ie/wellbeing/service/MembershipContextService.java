package ie.wellbeing.service;


public interface MembershipContextService {

    public void changeStateTo(MembershipState newState, Integer userId);
    public String handle();
}
