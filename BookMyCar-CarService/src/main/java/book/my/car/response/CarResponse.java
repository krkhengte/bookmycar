package book.my.car.response;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CarResponse {

	private String id;
	private String carImg;
	private String car360;
	private String carCompany;
	private String carModel;
	private String carColor;
	private String carOwner;
	private Double charge;
	private LocalDate regDate;
	private String carType;
	private Integer passangerCapacity;
	private String fuelType;
	private Long totalRunning;
	private String numPlate;
	private LocalDate insuranceValidity;
	private String insurance;
	private String feature;

}