package book.my.car.service;

import java.util.List;

import book.my.car.request.AtmApiRequest;
import book.my.car.response.AtmApiResponse;
import book.my.car.response.CarBookingResponse;

public interface AtmService {

	public AtmApiResponse makePayment(AtmApiRequest apiRequest);

	public List<CarBookingResponse> getBookingDetailsByEmail(String email);
}
