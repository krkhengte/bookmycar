package book.my.car.service;

import java.util.List;
import java.util.Map;

import book.my.car.request.CarRequest;

import book.my.car.response.CarResponse;


public interface CarService {

	public CarResponse saveCar(CarRequest carRequest);
	
	public List<CarResponse> getAllCars();
	
	public CarResponse getCarByCarId(String carId);
	
	public CarResponse updateSpecificField(String numPlate, Map<String, Object> fields);
	
	public String updateDriverDetails(String modelNum ,CarRequest cRequest);
	
}
