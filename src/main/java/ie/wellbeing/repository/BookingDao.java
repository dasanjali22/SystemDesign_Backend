package ie.wellbeing.repository;

import ie.wellbeing.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;


/*
Authors : Sai Rohit Voleti & Subhiksha
 */
@Repository
public interface BookingDao extends JpaRepository<Booking, Integer>{

    List<Booking> findByUserId(Integer userId);

    List<Booking> findBySessionSlot(String sessionSlot);

}