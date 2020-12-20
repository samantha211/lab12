package com.sweg6409.Patient.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweg6409.Patient.controllers.repositories.PatientRepository;
import com.sweg6409.Patient.models.Patient;

@Service
public class PatientService {

	//List<Patient> patientList = new ArrayList<>();
	
	@Autowired
	PatientRepository patientRepository;
	
	//create
	public Patient createPatient(Patient pat){
		patientRepository.save(pat);
		return pat;
	}
	
	//read
	//Return list of patients
	public List<Patient> findAllPatients(){
		return (List<Patient>) patientRepository.findAll();
	}
	//Return list of patients base on selected illness
	public List<Patient> findAllPatientsByIllness(String illness){
		return ((List<Patient>) patientRepository.findAll()).stream().filter(p->p.getIllness().equalsIgnoreCase(illness)).collect(Collectors.toList());
	}
	//update
	public void updatePatient(Integer id, Patient p) {
		/*for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getId().equals(id)) {
				patientList.set(i, p);
			}
		}
		*/
		patientRepository.findById(id).ifPresent(pat ->{
			pat.setGender(p.getGender());
			pat.setIllness(p.getIllness());
			pat.setName(p.getName());
		});
	}
	//delete
	public void deletePatient(Integer id) {
		//patientList = patientList.stream().filter(p -> p.getId() != id).collect(Collectors.toList());
		patientRepository.deleteById(id);
	}
}
