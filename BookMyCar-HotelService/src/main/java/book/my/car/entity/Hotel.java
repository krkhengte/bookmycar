package book.my.car.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String hotel;
    private String room;
    private Integer stay;
    private String manageParking;
    private Long finalCost;
}