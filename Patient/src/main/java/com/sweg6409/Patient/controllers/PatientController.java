package com.sweg6409.Patient.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweg6409.Patient.models.Patient;
import com.sweg6409.Patient.services.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	PatientService PatientServices;
	
	//create
	@PostMapping("/api/v1/patients")
	public Patient createPatient(@RequestBody Patient patient) {
		return PatientServices.createPatient(patient);
		
	}
	//read
	@GetMapping("/api/v1/patients")
	public List<Patient> findAllPatients(){
		return PatientServices.findAllPatients();
	}
	
	@GetMapping("/api/v1/patients/{illness}")
	public List<Patient> findAllPatientsByIllness(@PathVariable("illness") String illness){
		return PatientServices.findAllPatientsByIllness(illness);
		
	}
	
	//update
	@PutMapping("/api/v1/patients/{id}")
	public String updatePatient(@PathVariable("id") Integer id, @RequestBody Patient patient){
		PatientServices.updatePatient(id, patient);
		return "Patient with Id " + id + " has been updated!";
		
	}
	//delete
	@DeleteMapping("/api/v1/patients/{id}")
	public String deletePatient(@PathVariable("id") Integer id){
		PatientServices.deletePatient(id);
		return "Patient with Id "+id+ " has been deleted!";
	}
	

}
