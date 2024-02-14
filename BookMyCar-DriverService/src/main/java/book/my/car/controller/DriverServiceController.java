package book.my.car.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import book.my.car.request.DriverApiRequest;
import book.my.car.response.DriverApiResponse;
import book.my.car.service.DriverService;

@RestController
@CrossOrigin
@RequestMapping("/drivers")
public class DriverServiceController {

	@Autowired
	private DriverService driverService;

	@PostMapping("/saveDriver")
	public ResponseEntity<DriverApiResponse> saveDriver(@RequestBody DriverApiRequest dRequest) {

		DriverApiResponse saveDriver = driverService.saveDriver(dRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(saveDriver);

	}

	@GetMapping("/getAllDriver")
	public ResponseEntity<List<DriverApiResponse>> getAllDrivers() {

		List<DriverApiResponse> allDriversDetails = driverService.getAllDriversDetails();

		return ResponseEntity.status(HttpStatus.CREATED).body(allDriversDetails);

	}

	@GetMapping("/getDriverById/{driverId}")
	public ResponseEntity<DriverApiResponse> getDriverById(@PathVariable String driverId) {

		DriverApiResponse saveDriver = driverService.getDriverById(driverId);

		return ResponseEntity.status(HttpStatus.CREATED).body(saveDriver);

	}

//	@PatchMapping(value = "/updateSpecificValue/{mobNum}", consumes = { "multipart/form-data", "application/json",
//			"application/xml" })
//	public ResponseEntity<DriverApiResponse> updateSpecificField(@PathVariable("mobNum") Long mobNum,
//			@RequestBody Map<String, Object> objectMap) {
//		System.out.println(objectMap.isEmpty());
//		DriverApiResponse dResponse = this.driverService.updateSpecificField(mobNum, objectMap);
//		return ResponseEntity.ok(dResponse);
//	}
	
	@PutMapping("/updateDriverDetails/{mobNum}")
	public ResponseEntity<String> updateDriverDetails(@PathVariable Long mobNum, @RequestBody DriverApiRequest dRequest) {

		 String updateDriverDetails = driverService.updateDriverDetails(mobNum,dRequest);
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(updateDriverDetails);

	}
	
//	@PatchMapping("/book/{mobNo}")
//    public void bookDriver(@PathVariable Long mobNo ){
//        log.info("entered book driver controller:"+mobNo);
//        driverService.changeStatusOfDriver(mobNo);
//    }

}
