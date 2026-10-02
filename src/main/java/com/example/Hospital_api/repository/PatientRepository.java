package com.example.Hospital_api.repository;

import com.example.Hospital_api.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}