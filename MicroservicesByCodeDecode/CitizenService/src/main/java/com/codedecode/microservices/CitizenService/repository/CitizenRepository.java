package com.codedecode.microservices.CitizenService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codedecode.microservices.CitizenService.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen, Integer>{

		List<Citizen>findAllCitizensByVaccinationCentreId(Integer vaccinationCentreId);
}
