package com.javabrains.movieinfoservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@RequestMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieid){
		return new Movie(movieid, "Test name");
		
		
	}

}
