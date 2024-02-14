package book.my.car.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import book.my.car.response.CarResponse;

@FeignClient("CAR-SERVICE")
public interface CarService {

	@GetMapping("/cars/car/{carId}")
	public CarResponse getCarByCarId(@PathVariable String carId);
}
