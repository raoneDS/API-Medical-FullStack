package br.com.beyoux.apifullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.com.beyoux.apifullstack.entities")
@SpringBootApplication
public class ApifullstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApifullstackApplication.class, args);
	}

}
