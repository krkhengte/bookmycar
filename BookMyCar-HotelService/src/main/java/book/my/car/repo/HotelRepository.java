package book.my.car.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import book.my.car.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
