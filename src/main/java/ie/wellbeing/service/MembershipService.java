package ie.wellbeing.service;


import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.request.MembershipRequest;
import java.util.List;

public interface MembershipService {
    String createMembership(MembershipRequest membershipRequest, String siteURL) throws Exception;

    void updateMembershipDetails(Integer userId, String type);

    List<MembershipDetails> getAllUsersMembershipDetails();
}
