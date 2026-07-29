package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Doctor;
import com.klef.soa.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController
{
	@Autowired
	private DoctorService service;

	@GetMapping("/")
	public String demo()
	{
		return "Spring Boot Project";
	}

	// Add Doctor
	@PostMapping("/add")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor d)
	{
		Doctor doctor = service.addDoctor(d);
		return ResponseEntity.status(201).body(doctor);
	}

	// Display All Doctors
	@GetMapping("/displayall")
	public ResponseEntity<List<Doctor>> displayAllDoctors()
	{
		List<Doctor> doctors = service.displayAllDoctors();
		return ResponseEntity.status(200).body(doctors);
	}

	// Display Doctor By ID
	@GetMapping("/display")
	public ResponseEntity<?> displayDoctorById(@RequestParam Long id)
	{
		Doctor doctor = service.displayDoctorById(id);

		if (doctor != null)
		{
			return ResponseEntity.status(200).body(doctor);
		}
		else
		{
			return ResponseEntity.status(404).body("Doctor ID Not Found");
		}
	}

	// Update Doctor
	@PutMapping("/update")
	public ResponseEntity<?> updateDoctor(@RequestBody Doctor doctor)
	{
		Doctor d = service.updateDoctor(doctor);

		if (d != null)
		{
			return ResponseEntity.ok(d);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor ID Not Found");
		}
	}

	// Delete Doctor By ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable Long id)
	{
		String message = service.deleteDoctorById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// Display Doctors By Gender
	@GetMapping("/displaybygender/{gender}")
	public ResponseEntity<List<Doctor>> displayDoctorsByGender(@PathVariable String gender)
	{
		List<Doctor> doctors = service.displayDoctorsByGender(gender);
		return ResponseEntity.status(200).body(doctors);
	}
	
	// Doctor Count
	@GetMapping("/count")
	public ResponseEntity<String> doctorcount() 
	{
		Long count =  service.doctorCount();
	    String msg = "Total Doctors="+count;
	    return ResponseEntity.ok(msg);
		}
}