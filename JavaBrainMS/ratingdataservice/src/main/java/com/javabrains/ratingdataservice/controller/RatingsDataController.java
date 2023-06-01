package com.javabrains.ratingdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.ratingdataservice.model.Rating;
import com.javabrains.ratingdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataController {
	
	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("123",4),
				new Rating("456",5)
		);
	UserRating userRating =	new UserRating();
	userRating.setUseRrating(ratings);
		return userRating;
	}


}
