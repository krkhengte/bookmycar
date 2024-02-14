package book.my.car.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import book.my.car.entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, String>{

}
