package com.codedecode.microservices.CitizenService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.microservices.CitizenService.entity.Citizen;
import com.codedecode.microservices.CitizenService.service.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@Autowired
	private CitizenService citizenService;
	
	@RequestMapping(path="/{vaccinationCentreId}")
	public ResponseEntity<List<Citizen>> getCitizenByVaccinationCentreId(@PathVariable("vaccinationCentreId") Integer vaccinationCentreId){
	List<Citizen> citizenList = citizenService.getCitizenByVaccinationCentreId(vaccinationCentreId);
		return new ResponseEntity<>(citizenList,HttpStatus.OK);
	} 
	
	@PostMapping(path="/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen){
	Citizen newCitizen = citizenService.addCitizen(citizen);
		return new ResponseEntity<>(newCitizen,HttpStatus.OK);
	} 
	
}
