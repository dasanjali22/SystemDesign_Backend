package ie.wellbeing.service;


import ie.wellbeing.model.MembershipDetails;
import ie.wellbeing.DTO.MembershipRequestDto;
import java.util.List;

public interface MembershipService {
    String createMembership(MembershipRequestDto membershipRequestDto, String siteURL) throws Exception;

    void updateMembershipDetails(Long userId, String type);

    List<MembershipDetails> getAllUsersMembershipDetails();
}
