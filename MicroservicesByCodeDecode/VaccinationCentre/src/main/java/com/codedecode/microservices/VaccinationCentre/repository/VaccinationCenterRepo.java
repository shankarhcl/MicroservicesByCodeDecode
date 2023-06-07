package com.codedecode.microservices.VaccinationCentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codedecode.microservices.VaccinationCentre.entity.VaccinationCentre;

public interface VaccinationCenterRepo  extends JpaRepository<VaccinationCentre, Integer>{

}
