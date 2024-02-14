package book.my.car.service;

import java.util.List;
import java.util.Map;

import book.my.car.request.DriverApiRequest;
import book.my.car.response.DriverApiResponse;

public interface DriverService {

	public DriverApiResponse saveDriver(DriverApiRequest dRequest);
	
	public List<DriverApiResponse> getAllDriversDetails();
	
	public DriverApiResponse getDriverById(String driverId);
	
//	public DriverApiResponse updateSpecificField(Long mobNum, Map<String, Object> fields);
//	
	public String updateDriverDetails(Long mobNum ,DriverApiRequest dRequest);
	
//	 public void changeStatusOfDriver(Long mobNo);
}