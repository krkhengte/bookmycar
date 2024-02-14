package book.my.car.request;

import lombok.Data;

@Data
public class DriverApiRequest {

    private String driverImg;
    private String driverName;
    private String drivingExperiance;
    private long driverMobNo;
    private String availability;
    private String food;
    private String smoke;
    private String drink;
    private int charges;
    private int __v;
}
