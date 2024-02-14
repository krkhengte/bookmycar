package book.my.car.service;

import java.util.List;

import book.my.car.request.BookingApiRequest;
import book.my.car.response.BookingApiResponse;

public interface BookingService {

	public BookingApiResponse saveBooking(BookingApiRequest bRequest);
	
	
}
