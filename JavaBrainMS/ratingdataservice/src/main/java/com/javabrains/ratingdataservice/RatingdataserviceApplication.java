package com.javabrains.ratingdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //optional
public class RatingdataserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingdataserviceApplication.class, args);
	}

}
