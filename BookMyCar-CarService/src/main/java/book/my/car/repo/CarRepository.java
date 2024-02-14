package book.my.car.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import book.my.car.entity.CarDetails;

@Repository
public interface CarRepository extends JpaRepository<CarDetails, String>{

	
	public CarDetails findByNumPlate(String numPlate);
	
	public CarDetails findByCarModel(String carModel);
}
