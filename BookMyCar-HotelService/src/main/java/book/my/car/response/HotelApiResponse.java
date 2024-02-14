package book.my.car.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelApiResponse {

	private String id;
	private String hotel;
    private String room;
    private Integer stay;
    private String manageParking;
    private Long finalCost;
  
}
