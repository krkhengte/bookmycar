package book.my.car.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import book.my.car.entity.CarDetails;

import book.my.car.exception.ResourceNotFoundException;
import book.my.car.repo.CarRepository;
import book.my.car.request.CarRequest;

import book.my.car.response.CarResponse;
import book.my.car.service.CarService;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepository;
	
	@Override
	public CarResponse saveCar(CarRequest carRequest) {
		
		CarResponse carResponse=new CarResponse();
		
		BeanUtils.copyProperties(carRequest, carResponse);
		
		CarDetails carDetails=new CarDetails();
		
		BeanUtils.copyProperties(carRequest, carDetails);
		
		carRepository.save(carDetails);
		
		
		return carResponse;
	}

	@Override
	public List<CarResponse> getAllCars() {
		
		List<CarDetails> carList = carRepository.findAll();
		
		List<CarResponse> carResponses=new ArrayList<>();
		
		for(CarDetails carDetails : carList) {
			
			CarResponse carResponse=new CarResponse();
			
			BeanUtils.copyProperties(carDetails, carResponse);
			
			if (carDetails.getStatus().equalsIgnoreCase("Available")) {
			
				carResponses.add(carResponse);
			}
		
		}

		return carResponses;
	}

	@Override
	public CarResponse getCarByCarId(String carId) {
		
		CarDetails carDetails = carRepository.findById(carId).orElseThrow(()-> new ResourceNotFoundException("Car", "CarId", carId));
		
		CarResponse cResponse=new CarResponse();
		
		BeanUtils.copyProperties(carDetails, cResponse);
		return cResponse;
	}

	@Override
	public CarResponse updateSpecificField(String numPlate, Map<String, Object> fields) {
		CarDetails carDetails = this.carRepository.findByNumPlate(numPlate);				
		fields.forEach((key, value) -> {
			Field field = org.springframework.util.ReflectionUtils.findField(CarDetails.class, key);
			Optional<Field> optionalField = Optional.ofNullable(field);
			if (optionalField.isPresent()) {
				field.setAccessible(true);
				ReflectionUtils.setField(field, carDetails, value);
			} else {
				System.err.println("Field not found: " + key);
			}
		});
		CarDetails savedUser = carRepository.save(carDetails);
		CarResponse carResponse = new CarResponse();
		BeanUtils.copyProperties(savedUser, carResponse);
		return carResponse;
		
	}

	@Override
	public String updateDriverDetails(String modelNum, CarRequest cRequest) {
	
			CarDetails carDetails = carRepository.findByCarModel(modelNum);

			CarDetails carDetails2 = new CarDetails();

			BeanUtils.copyProperties(carDetails, carDetails2);

			System.out.println(carDetails2.getStatus());
			
			carDetails2.setStatus("Booked");
			carRepository.save(carDetails2);

			return "Status Updated Successfully.....!";
		}
	

}
