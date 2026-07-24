package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Doctor;
import com.klef.soa.service.DoctorService;


@RestController
public class DoctorController
{
  @Autowired
  private DoctorService service;
  
  @GetMapping("/")
  public String demo()
  {
	  return "Spring Boot Project";
  }
  @PostMapping("/add")
  public ResponseEntity<Doctor> adddoctor(@RequestBody Doctor d)
  {
	  Doctor doctor = service.addDoctor(d);
	  return ResponseEntity.status(201).body(doctor);
  }
  
  @GetMapping("/displayall")
  public ResponseEntity<List<Doctor>> displayalldoctors()
  {
	  List<Doctor> doctors = service.displayAllDoctors();
	  return ResponseEntity.status(200).body(doctors);
  }
  
  
  
}
