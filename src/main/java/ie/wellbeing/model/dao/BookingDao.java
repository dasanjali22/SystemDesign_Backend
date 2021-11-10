package ie.wellbeing.model.dao;

import ie.wellbeing.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingDao extends JpaRepository<Booking, Integer>{
     //Booking save(Booking booking);
     Booking findBookingByUserId(Integer id);

     @Override
     List<Booking> findAll();
}


