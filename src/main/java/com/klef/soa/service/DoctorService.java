package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Doctor;

public interface DoctorService {

	Doctor addDoctor(Doctor d) ;
	Doctor updateDoctor(Doctor d);
	List<Doctor> displayAllDoctors();
	Doctor displayDoctorById(Long id);
	String deleteDoctorById(Long id);
	List<Doctor> displayDoctorsByGender(String gender);
	Long doctorCount();
	
}
