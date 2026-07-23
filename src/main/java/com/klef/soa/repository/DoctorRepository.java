package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.soa.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
