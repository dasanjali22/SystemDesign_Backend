package ie.wellbeing.repository;

import ie.wellbeing.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/*
Authors : Sai Rohit Voleti & Subhiksha
 */
@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{

    List<Booking> findByUserId(Long userId);

    List<Booking> findBySessionSlot(String sessionSlot);

}