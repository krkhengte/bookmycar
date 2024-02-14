package book.my.car.service.impl;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.my.car.entity.Booking;
import book.my.car.externalService.CarService;
import book.my.car.repo.BookingRepo;
import book.my.car.request.BookingApiRequest;
import book.my.car.response.BookingApiResponse;
import book.my.car.response.CarResponse;
import book.my.car.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepo bookingRepo;

	@Autowired
	private CarService carService;

	@Override
	public BookingApiResponse saveBooking(BookingApiRequest bRequest) {

		// String bookingId = UUID.randomUUID().toString();

		CarResponse carDetails = carService.getCarByCarId(bRequest.getCarId());
		System.out.println(carDetails.getId());
		BookingApiResponse bApiResponse = new BookingApiResponse();

		bApiResponse.set__v(0);
		bApiResponse.setId(bRequest.getId());
		bApiResponse.setCarColor(carDetails.getCarColor());
		bApiResponse.setCarCompany(carDetails.getCarCompany());
		bApiResponse.setCarImg(carDetails.getCarImg());
		bApiResponse.setCarModel(carDetails.getCarModel());
		bApiResponse.setCarOwner(carDetails.getCarOwner());
		bApiResponse.setCarType(carDetails.getCarType());
		bApiResponse.setDays(bRequest.getDays());
		bApiResponse.setDropDate(bRequest.getDropDate());
		bApiResponse.setDropLocation(bRequest.getDropLocation());
		bApiResponse.setFeature(carDetails.getFeature());
		bApiResponse.setFuelType(carDetails.getFuelType());
		bApiResponse.setInsuranceValidity(carDetails.getInsuranceValidity());
		bApiResponse.setMembers(bRequest.getMembers());
		bApiResponse.setNumBags(bRequest.getNumBags());
		bApiResponse.setPickUpTime(bRequest.getPickUpTime());
		bApiResponse.setPickUpDate(bRequest.getPickUpDate());
		bApiResponse.setPickUpLocation(bRequest.getPickUpLocation());

		 bApiResponse.setTotalPrice(carDetails.getCharge()*bRequest.getDays());

		Booking booking = new Booking();

		BeanUtils.copyProperties(bApiResponse, booking);

		bookingRepo.save(booking);

		return bApiResponse;
	}

}