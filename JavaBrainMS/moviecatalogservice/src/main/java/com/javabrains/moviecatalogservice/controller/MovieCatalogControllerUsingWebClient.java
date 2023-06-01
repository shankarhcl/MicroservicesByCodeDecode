package com.javabrains.moviecatalogservice.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.javabrains.moviecatalogservice.controller.model.CatalogItem;
import com.javabrains.moviecatalogservice.controller.model.Movie;
import com.javabrains.moviecatalogservice.controller.model.Rating;

@RestController
@RequestMapping("/catalog/webclient")
public class MovieCatalogControllerUsingWebClient {
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("123",4),
				new Rating("456",5)
		);
		return ratings.stream().map(rating -> {
		Movie movie = 	webClientBuilder
			.build()
			.get() //http method
			.uri("http://localhost:8082/movies/"+rating.getMovieId())
			.retrieve() //to fetch data on behalf of uri
			.bodyToMono(Movie.class) //whatever body we will get convert it into Movie class instance which is reactive way to get an object
			.block(); //blocking execution till mono is fulfilled
			return new CatalogItem(movie.getName(), "Test", rating.getRating());
		}).collect(Collectors.toList());	
	}	
}
