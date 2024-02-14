package book.my.car.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "driverMobNo")})
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private String 	id;
    private String driverImg;
    private String driverName;
    private String drivingExperiance;
    private long driverMobNo;
    private String availability;
    private String food;
    private String smoke;
    private String drink;
    private int charges;
  //  private String status;
    private int __v;
}
