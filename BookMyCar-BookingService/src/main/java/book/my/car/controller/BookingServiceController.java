package book.my.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import book.my.car.request.BookingApiRequest;
import book.my.car.response.BookingApiResponse;
import book.my.car.service.BookingService;

@RestController
@CrossOrigin
@RequestMapping("/bookings")
public class BookingServiceController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/saveBooking")
	public ResponseEntity<BookingApiResponse> saveBooking(@RequestBody BookingApiRequest bRequest){
		
		BookingApiResponse saveBooking = bookingService.saveBooking(bRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveBooking);
	}
	
}