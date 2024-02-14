package book.my.car.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.my.car.entity.AtmDetails;
import book.my.car.externalService.CarService;
import book.my.car.externalService.DriverService;
import book.my.car.repo.AtmRepository;
import book.my.car.request.AtmApiRequest;
import book.my.car.request.CarRequest;
import book.my.car.request.DriverApiRequest;
import book.my.car.response.AtmApiResponse;
import book.my.car.response.CarBookingResponse;
import book.my.car.service.AtmService;

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	private AtmRepository atmRepository;

	@Autowired
	private DriverService driverService;
	
	@Autowired
	private CarService carService;

	// String email=null;
	@Override
	public AtmApiResponse makePayment(AtmApiRequest apiRequest) {

		AtmApiResponse aResponse = new AtmApiResponse();

		String email = apiRequest.getEmail();

		aResponse.setCarColor(apiRequest.getCarColor());
		aResponse.setCarCompany(apiRequest.getCarCompany());
		aResponse.setCardNo(apiRequest.getCardNo());
		aResponse.setCarImg(apiRequest.getCarImg());
		aResponse.setCarModel(apiRequest.getCarModel());
		aResponse.setCarType(apiRequest.getCarType());
		aResponse.setCharge(apiRequest.getCharge());
		aResponse.setCharges(apiRequest.getCharges());
		aResponse.setDays(apiRequest.getDays());
		aResponse.setDriverID(apiRequest.getDriverID());
		aResponse.setDriverImg(apiRequest.getDriverImg());
		aResponse.setDriverMobNo(apiRequest.getDriverMobNo());
		aResponse.setDriverName(apiRequest.getDriverName());
		aResponse.setDropDate(apiRequest.getDropDate());
		aResponse.setDropLocation(apiRequest.getDropLocation());
		aResponse.setEmail(apiRequest.getEmail());
		aResponse.setFinalCost(apiRequest.getFinalCost());
		aResponse.setFname(apiRequest.getFname());
		aResponse.setFuelType(apiRequest.getFuelType());
		aResponse.setHotel(apiRequest.getHotel());
		aResponse.setLname(apiRequest.getLname());
		aResponse.setManageParking(apiRequest.getManageParking());
		aResponse.setMembers(apiRequest.getMembers());
		aResponse.setPassangerCapacity(apiRequest.getPassangerCapacity());
		aResponse.setPickUpDate(apiRequest.getPickUpDate());
		aResponse.setPickUpTime(apiRequest.getPickUpTime());
		aResponse.setRoom(apiRequest.getRoom());
		aResponse.setStay(apiRequest.getStay());

		AtmDetails atmDetails = new AtmDetails();

		BeanUtils.copyProperties(apiRequest, atmDetails);

		AtmDetails save = atmRepository.save(atmDetails);

		DriverApiRequest dreRequest=new DriverApiRequest();
		
		driverService.updateDriverDetails(apiRequest.getDriverMobNo(),dreRequest);
		
		CarRequest cRequest=new CarRequest();
		carService.updateCarDetails(apiRequest.getCarModel(), cRequest);

		return aResponse;
	}

	@Override
	public List<CarBookingResponse> getBookingDetailsByEmail(String email) {

		List<AtmDetails> findByEmail = atmRepository.findByEmail(email);

		List<CarBookingResponse> carBookingResponse = new ArrayList<>();

		for (AtmDetails atmDetails : findByEmail) {

			CarBookingResponse cResponse = new CarBookingResponse();

			BeanUtils.copyProperties(atmDetails, cResponse);

			carBookingResponse.add(cResponse);
		}

		return carBookingResponse;
	}

}
