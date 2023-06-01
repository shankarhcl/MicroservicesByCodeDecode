package com.javabrains.moviecatalogservice.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatalogItem {
	
	private String movieName;
	private String desc;
	private int rating;

}
