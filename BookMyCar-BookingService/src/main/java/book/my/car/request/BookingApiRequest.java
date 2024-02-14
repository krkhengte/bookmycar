package book.my.car.request;

import lombok.Data;

@Data
public class BookingApiRequest {

	private String id;
    private String carId;
    private String pickUpLocation;
    private String dropLocation;
    private String pickUpTime;
    private String pickUpDate;
    private String dropDate;
    private int passangerCapacity;
    private int members;
    private int days;
    private int numBags;
}
