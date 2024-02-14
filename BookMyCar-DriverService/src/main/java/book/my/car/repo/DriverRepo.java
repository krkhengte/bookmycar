package book.my.car.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import book.my.car.entity.Driver;
@Repository
public interface DriverRepo extends JpaRepository<Driver, String>{

	public Driver findByDriverMobNo(long mobNum);
}