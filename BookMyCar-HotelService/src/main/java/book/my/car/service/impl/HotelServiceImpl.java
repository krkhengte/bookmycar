package book.my.car.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.my.car.entity.Hotel;
import book.my.car.repo.HotelRepository;
import book.my.car.request.HotelApiRequest;
import book.my.car.response.HotelApiResponse;
import book.my.car.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hRepository;

	@Override
	public HotelApiResponse saveHotel(HotelApiRequest hRequest) {

		HotelApiResponse hResponse = new HotelApiResponse();

		Hotel hotel = new Hotel();

		BeanUtils.copyProperties(hRequest, hotel);

		BeanUtils.copyProperties(hRequest, hResponse);
		
		Hotel save = hRepository.save(hotel);
		hResponse.setId(save.getId());
		//hResponse.set_v(0);
		BeanUtils.copyProperties(hRequest, hResponse);

		return hResponse;
	}

}
