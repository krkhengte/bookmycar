package book.my.car.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import book.my.car.entity.AtmDetails;

public interface AtmRepository extends JpaRepository<AtmDetails, String> {

	public List<AtmDetails> findByEmail(String email);
}
