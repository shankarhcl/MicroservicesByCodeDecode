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

import com.javabrains.moviecatalogservice.controller.model.CatalogItem;
import com.javabrains.moviecatalogservice.controller.model.Movie;
import com.javabrains.moviecatalogservice.controller.model.Rating;
import com.javabrains.moviecatalogservice.controller.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogControllerUsingRestTemplate {
	
	//telling spring give me rest template instance ie. Autowire is a consumer
	//spring check that its autowired so it check its instance first
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		//get all rated movie ids
		UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId, UserRating.class);
		//for each movieId call movieinfoservice and get details
		return ratings.getUseRrating().stream().map(rating -> {
			//We should not return a list from an api as a root node as only object expected as we can pass Movie.class but not List. We can pass PrameterizedTypeReference<List<Movie>> but why to make so complex
		Movie movie =restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
		//put them all together
		return new CatalogItem(movie.getName(), "Test", rating.getRating());
		}).collect(Collectors.toList());
		//return Collections.singletonList(new CatalogItem("Transformers", "Test", 4));
	}
}
