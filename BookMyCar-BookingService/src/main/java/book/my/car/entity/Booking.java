package book.my.car.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
    private String carId;
    private String pickUpLocation;
    private String dropLocation;
    private String pickUpTime;
    private String pickUpDate;
    private Long price;
    private String dropDate;
    private Integer passangerCapacity;
    private Integer members;
    private Integer days;
    private Integer numBags;
}
