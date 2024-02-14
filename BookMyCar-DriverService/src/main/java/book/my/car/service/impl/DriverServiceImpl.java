package book.my.car.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.my.car.entity.Driver;
import book.my.car.exception.ResourceNotFoundException;
import book.my.car.repo.DriverRepo;
import book.my.car.request.DriverApiRequest;
import book.my.car.response.DriverApiResponse;
import book.my.car.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepo driverRepo;

	@Override
	public DriverApiResponse saveDriver(DriverApiRequest dRequest) {

		DriverApiResponse apiResponse = new DriverApiResponse();

		Driver driver = new Driver();

		BeanUtils.copyProperties(dRequest, driver);

		BeanUtils.copyProperties(dRequest, apiResponse);

		driverRepo.save(driver);

		return apiResponse;
	}

	@Override
	public List<DriverApiResponse> getAllDriversDetails() {

		List<Driver> driverList = driverRepo.findAll();

		List<DriverApiResponse> dResponses = new ArrayList<>();

		for (Driver driver : driverList) {

			DriverApiResponse dApiResponse = new DriverApiResponse();

			BeanUtils.copyProperties(driver, dApiResponse);

			if (driver.getAvailability().equalsIgnoreCase("Available")) {
				dResponses.add(dApiResponse);
			}
		}

		return dResponses;
	}

	@Override
	public DriverApiResponse getDriverById(String driverId) {

		Driver driver = driverRepo.findById(driverId)
				.orElseThrow(() -> new ResourceNotFoundException("Driver", "DriverId", driverId));

		DriverApiResponse dApiResponse = new DriverApiResponse();

		return dApiResponse;
	}


	@Override
	public String updateDriverDetails(Long mobNum,DriverApiRequest dRequest) {

		Driver findByDriverMobNo = driverRepo.findByDriverMobNo(mobNum);

		Driver driver = new Driver();

		BeanUtils.copyProperties(findByDriverMobNo, driver);

		System.out.println(driver.getAvailability());
		
		driver.setAvailability("Booked");
		driverRepo.save(driver);
		
		return "Status Updated Successfully.....!";
	}

}
