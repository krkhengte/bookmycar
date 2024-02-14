package book.my.car.service;

import org.springframework.security.core.userdetails.UserDetails;

import book.my.car.apiresponse.LoginApiResponse;
import book.my.car.payload.LoginDto;

public interface LoginService {

	public LoginApiResponse loginUser(LoginDto loginDto);
	
//	public LoginApiResponse getUserInfo(String userName);
	
}