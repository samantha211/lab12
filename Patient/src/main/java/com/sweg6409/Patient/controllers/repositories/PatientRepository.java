package com.sweg6409.Patient.controllers.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sweg6409.Patient.models.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer>{

}
