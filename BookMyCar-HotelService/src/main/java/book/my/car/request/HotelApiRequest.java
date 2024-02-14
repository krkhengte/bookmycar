package book.my.car.request;

import lombok.Data;

@Data
public class HotelApiRequest {


	private String hotel;
    private String room;
    private int stay;
    private String manageParking;
    private Long finalCost;
}
