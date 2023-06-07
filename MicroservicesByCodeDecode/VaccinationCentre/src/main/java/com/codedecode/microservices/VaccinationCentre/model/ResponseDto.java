package com.codedecode.microservices.VaccinationCentre.model;

import java.util.List;

import com.codedecode.microservices.VaccinationCentre.entity.VaccinationCentre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
	
	private VaccinationCentre centre;
	
	private List<Citizen> citizens;
}
