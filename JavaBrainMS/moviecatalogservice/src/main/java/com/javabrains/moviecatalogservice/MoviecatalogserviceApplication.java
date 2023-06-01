package com.javabrains.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class MoviecatalogserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviecatalogserviceApplication.class, args);
	}

	//only 1 time rest template instance will be created that will be share across project
	//can be add in any @component, anywhere in classpath
	//producer
	//bean initialization configurable so can be eager or lazy
	//method name doesnt method but type matter
	//RestTemplate is Thread safe
	//RestTemplate is synchronous approach which is deprecated and now web client is suggested
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	//spring-boot-starter-webflux dependecy need as web client is reactive and SB doesn't provide it in its classpath
	//web client can be used as synchronously and asynchronously
	@Bean
	WebClient.Builder getWebClientBuilder(){
		return WebClient.builder(); 
	}
}
