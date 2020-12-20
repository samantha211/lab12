package com.sweg6409.Patient.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Patient")
public class Patient {
	
	String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String gender;
	String illness;
	
	public Patient(String name, String gender, String illness) {
		super();
		this.name = name;
		this.gender = gender;
		this.illness = illness;
	}
	
	public Patient() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}

	@Override
	public String toString() {
		return "Patient [getId()=" + getId() + ", getGender()=" + getGender() + ", getIllness()=" + getIllness() + "]";
	}

}
