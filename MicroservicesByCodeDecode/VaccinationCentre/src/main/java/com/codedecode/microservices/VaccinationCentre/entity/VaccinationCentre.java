package com.codedecode.microservices.VaccinationCentre.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationCentre {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String centreName;
	
	private String centreAddress;

}
