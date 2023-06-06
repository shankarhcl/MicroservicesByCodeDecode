package com.codedecode.microservices.CitizenService.service;

import java.util.List;

import com.codedecode.microservices.CitizenService.entity.Citizen;

public interface CitizenService {
	
		public List<Citizen>getCitizenByVaccinationCentreId(Integer vaccinationCentreId);
		
		public Citizen addCitizen(Citizen citizen);
}
