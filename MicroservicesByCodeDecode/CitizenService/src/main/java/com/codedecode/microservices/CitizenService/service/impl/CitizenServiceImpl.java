package com.codedecode.microservices.CitizenService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.microservices.CitizenService.entity.Citizen;
import com.codedecode.microservices.CitizenService.repository.CitizenRepository;
import com.codedecode.microservices.CitizenService.service.CitizenService;

@Service
public class CitizenServiceImpl implements CitizenService{

	@Autowired
	private CitizenRepository citizenRepository;
	
	@Override
	public List<Citizen> getCitizenByVaccinationCentreId(Integer vaccinationCentreId) {
		List<Citizen> list =  citizenRepository.findAllCitizensByVaccinationCentreId(vaccinationCentreId);
		return list;
	}

	@Override
	public Citizen addCitizen(Citizen citizen) {
		return citizenRepository.save(citizen);
	}

}
