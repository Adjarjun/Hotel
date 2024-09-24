package com.example.Car_Rental_Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.Car_Rental_Spring")
@EnableJpaRepositories(basePackages = "com.example.Car_Rental_Spring.Repository")
public class CarRentalSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalSpringApplication.class, args);
	}

}
