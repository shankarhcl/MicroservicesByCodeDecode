package com.codedecode.microservices.VaccinationCentre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.codedecode.microservices.VaccinationCentre.entity.VaccinationCentre;
import com.codedecode.microservices.VaccinationCentre.model.Citizen;
import com.codedecode.microservices.VaccinationCentre.model.ResponseDto;
import com.codedecode.microservices.VaccinationCentre.repository.VaccinationCenterRepo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
	
	@Autowired
	private VaccinationCenterRepo vaccinationCenterRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(path="/add")
	public ResponseEntity<VaccinationCentre> addCitizen(@RequestBody VaccinationCentre center){
		VaccinationCentre newCenter = vaccinationCenterRepo.save(center);
		return new ResponseEntity<>(newCenter,HttpStatus.OK);
	} 

	@GetMapping(path="{id}")
	@HystrixCommand(fallbackMethod = "handleCitizenServiceDownTime")
	public ResponseEntity<ResponseDto>getAllDataBasedOncenterId(@PathVariable Integer id){
		
		ResponseDto dto =  new ResponseDto();
		
		VaccinationCentre centre = vaccinationCenterRepo.findById(id).get();
		dto.setCentre(centre);
    	List<Citizen> list =  	restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/"+id, List.class);
    	System.out.println("citizenList: "+list);
	    dto.setCitizens(list);
		return new ResponseEntity<ResponseDto>(dto,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseDto>handleCitizenServiceDownTime(@PathVariable Integer id){
		System.out.println("handleCitizenServiceDownTime");
		ResponseDto dto =  new ResponseDto();
		VaccinationCentre centre = vaccinationCenterRepo.findById(id).get();
		dto.setCentre(centre);
		return new ResponseEntity<ResponseDto>(dto,HttpStatus.OK);
	}

}
