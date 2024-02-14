package book.my.car.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AtmDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String fname;
    private String lname;
    private String email;
    private String driverImg;
    private String driverID;
    private String driverName;
    private long driverMobNo;
    private int charges;
    private String hotel;
    private String room;
    private int stay;
    private String manageParking;
    private long finalCost;
    private double charge;
    private String carCompany;
    private String carColor;
    private String carModel;
    private String carType;
    private String carImg;
    private String fuelType;
    private String pickUpLocation;
    private String dropLocation;
    private String pickUpTime;
    private String pickUpDate;
    private String dropDate;
    private int passangerCapacity;
    private int members;
    private int days;
    private String cardNo;
}
