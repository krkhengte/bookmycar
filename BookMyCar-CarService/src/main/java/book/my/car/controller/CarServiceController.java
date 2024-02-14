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

import book.my.car.request.CarRequest;
import book.my.car.response.CarResponse;
import book.my.car.service.CarService;


@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarServiceController {

	@Autowired
	private CarService carService;
	
	@PostMapping("/saveCar")
	public ResponseEntity<CarResponse> saveCar(@RequestBody CarRequest carRequest){
		
		CarResponse saveCar = carService.saveCar(carRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCar);
		
	}
	
	@GetMapping("/getAllCars")
	public ResponseEntity<List<CarResponse>> getAllCars(){
		
		List<CarResponse> allCars = carService.getAllCars();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(allCars);
	}
	
	
	@GetMapping("/car/{carId}")
	public ResponseEntity<CarResponse> getCarByCarId(@PathVariable String carId){
		
		CarResponse carByCarId = carService.getCarByCarId(carId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(carByCarId);
	}
	

	
	@PatchMapping(value = "/updateSpecificValue/{numPlate}",consumes = {"multipart/form-data","application/json","application/xml"})
    public ResponseEntity<CarResponse> updateSpecificField(@PathVariable ("numPlate") String numPlate,@RequestBody Map<String,Object> objectMap){
        System.out.println (objectMap.isEmpty ());
        CarResponse updatedUserDto = this.carService.updateSpecificField(numPlate,objectMap );
        return ResponseEntity.ok(updatedUserDto);
    }
	
	
	@PutMapping("/updateDriverDetails/{carModel}")
	public ResponseEntity<String> updateCarDetails(@PathVariable String carModel, @RequestBody CarRequest cRequest) {

		 String updateDriverDetails = carService.updateDriverDetails(carModel,cRequest);
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(updateDriverDetails);

	}
	
	
}
