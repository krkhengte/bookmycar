package book.my.car.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "carModel")})
public class CarDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String carImg;
    private String car360;
    private String status;
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