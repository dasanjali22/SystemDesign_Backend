package ie.wellbeing.repository;

import ie.wellbeing.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/*
Authors : Sai Rohit Voleti & Subhiksha
 */
@Repository
public interface BookingDao extends JpaRepository<Booking, Integer>{
    //Booking save(Booking booking);
    Booking findBookingByUserId(Integer id);

    @Override
    List<Booking> findAll();
}