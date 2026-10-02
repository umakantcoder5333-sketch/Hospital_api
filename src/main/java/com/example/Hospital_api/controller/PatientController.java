package com.example.Hospital_api.controller;

import com.example.Hospital_api.dto.PatientRequest;
import com.example.Hospital_api.dto.PatientResponse;
import com.example.Hospital_api.service.PatientService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // POST - Create patient
    @PostMapping("/api/patients")
    public PatientResponse createPatient(
            @Valid @RequestBody PatientRequest request) {

        return patientService.createPatient(request);
    }

    // GET - Get all patients
    @GetMapping("/api/patients")
    public List<PatientResponse> getAllPatients() {

        return patientService.getAllPatients();
    }

    // GET - Get patient by ID
    @GetMapping("/api/patients/{id}")
    public PatientResponse getPatientById(@PathVariable Long id) {

        return patientService.getPatientById(id);
    }

    // PUT - Update patient
    @PutMapping("/api/patients/{id}")
    public PatientResponse updatePatient(
            @PathVariable Long id,
            @Valid @RequestBody PatientRequest request) {

        return patientService.updatePatient(id, request);
    }

    // DELETE - Delete patient
    @DeleteMapping("/api/patients/{id}")
    public void deletePatient(@PathVariable Long id) {

        patientService.deletePatient(id);
    }
}