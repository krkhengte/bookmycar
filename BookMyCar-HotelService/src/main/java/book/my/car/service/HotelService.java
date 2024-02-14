package book.my.car.service;

import book.my.car.request.HotelApiRequest;
import book.my.car.response.HotelApiResponse;

public interface HotelService {

	public HotelApiResponse saveHotel(HotelApiRequest hRequest);
}
