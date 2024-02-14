package book.my.car.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import book.my.car.request.DriverApiRequest;

@FeignClient("DRIVER-SERVICE")
public interface DriverService {

	@PutMapping("/drivers/updateDriverDetails/{mobNum}")
	public String updateDriverDetails(@PathVariable Long mobNum, @RequestBody DriverApiRequest dRequest);
}