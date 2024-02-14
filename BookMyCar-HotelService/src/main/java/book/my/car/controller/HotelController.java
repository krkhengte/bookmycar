package book.my.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import book.my.car.request.HotelApiRequest;
import book.my.car.response.HotelApiResponse;
import book.my.car.service.HotelService;

@RestController
@CrossOrigin
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/saveHotel")
	public ResponseEntity<HotelApiResponse> saveHotel(@RequestBody HotelApiRequest hreRequest){
		System.out.println(hreRequest.getHotel());
		HotelApiResponse saveHotel = hotelService.saveHotel(hreRequest);
		System.out.println(saveHotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveHotel);
	}
}
