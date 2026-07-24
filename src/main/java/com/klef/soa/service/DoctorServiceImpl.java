package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Doctor;
import com.klef.soa.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService
{
	
	@Autowired
	private DoctorRepository doctorrepo;

	@Override
	public Doctor addDoctor(Doctor d)
	{
		 return doctorrepo.save(d);
	}

	@Override
	public Doctor updateDoctor(Doctor d) 
	{
		Optional<Doctor> optional = doctorrepo.findById(d.getId());
		if(optional.isPresent())
		{
			Doctor doctor = optional.get();
			doctor.setName(d.getName());
			doctor.setSalary(d.getSalary());
			doctor.setExperience(d.getExperience());
			doctor.setContact(d.getContact());
			
			return doctorrepo.save(doctor);
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Doctor> displayAllDoctors() 
	{
		return doctorrepo.findAll();
		
	}

	@Override
	public Doctor displayDoctorById(Long id) 
	{
	    return doctorrepo.findById(id).orElse(null);
	}

	@Override
	public String deleteDoctorById(Long id)
	{
		boolean flag = doctorrepo.existsById(id);
		if(flag)
		{
			doctorrepo.deleteById(id);
			return "Doctor Deleted Successfully";
		}
		else
		{
			return "Doctor ID Not Found";
		}
	}

	@Override
	public List<Doctor> displayDoctorsByGender(String gender)
	{
		return doctorrepo.findByGender(gender);
	}
	

}
