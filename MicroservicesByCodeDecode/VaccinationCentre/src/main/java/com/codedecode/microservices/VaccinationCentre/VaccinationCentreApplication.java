package com.codedecode.microservices.VaccinationCentre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker //deprecarted thatswhy we use relience +4j
public class VaccinationCentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationCentreApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return 	new RestTemplate();
	}
}
