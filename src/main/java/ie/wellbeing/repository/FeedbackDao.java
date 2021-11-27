package ie.wellbeing.repository;


import ie.wellbeing.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer> {

    Optional<Feedback> findById(Integer id);
}
