package book.my.car.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import book.my.car.request.CarRequest;

@FeignClient("CAR-SERVICE")
public interface CarService {

	
	@PutMapping("/cars/updateDriverDetails/{carModel}")
	public String updateCarDetails(@PathVariable String carModel, @RequestBody CarRequest cRequest);
}
