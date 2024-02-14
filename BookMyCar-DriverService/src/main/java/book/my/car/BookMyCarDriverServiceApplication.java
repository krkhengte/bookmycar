package book.my.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookMyCarDriverServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyCarDriverServiceApplication.class, args);
	}

}
