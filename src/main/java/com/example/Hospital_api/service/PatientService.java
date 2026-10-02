package com.example.Hospital_api.service;

import com.example.Hospital_api.dto.PatientRequest;
import com.example.Hospital_api.dto.PatientResponse;
import com.example.Hospital_api.entity.Patient;
import com.example.Hospital_api.exception.PatientNotFoundException;
import com.example.Hospital_api.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // POST - Create a new patient
    public PatientResponse createPatient(PatientRequest request) {

        Patient patient = new Patient();

        patient.setName(request.getName());
        patient.setAge(request.getAge());
        patient.setGender(request.getGender());
        patient.setPhone(request.getPhone());
        patient.setDisease(request.getDisease());

        Patient savedPatient = patientRepository.save(patient);

        return new PatientResponse(
                savedPatient.getId(),
                savedPatient.getName(),
                savedPatient.getAge(),
                savedPatient.getGender(),
                savedPatient.getPhone(),
                savedPatient.getDisease()
        );
    }

    // GET all patients
    public List<PatientResponse> getAllPatients() {

        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(patient -> new PatientResponse(
                        patient.getId(),
                        patient.getName(),
                        patient.getAge(),
                        patient.getGender(),
                        patient.getPhone(),
                        patient.getDisease()
                ))
                .toList();
    }

    // GET patient by ID
    public PatientResponse getPatientById(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));

        return new PatientResponse(
                patient.getId(),
                patient.getName(),
                patient.getAge(),
                patient.getGender(),
                patient.getPhone(),
                patient.getDisease()
        );
    }

    // PUT - Update patient
    public PatientResponse updatePatient(Long id, PatientRequest request) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));

        patient.setName(request.getName());
        patient.setAge(request.getAge());
        patient.setGender(request.getGender());
        patient.setPhone(request.getPhone());
        patient.setDisease(request.getDisease());

        Patient updatedPatient = patientRepository.save(patient);

        return new PatientResponse(
                updatedPatient.getId(),
                updatedPatient.getName(),
                updatedPatient.getAge(),
                updatedPatient.getGender(),
                updatedPatient.getPhone(),
                updatedPatient.getDisease()
        );
    }
    // DELETE - Delete patient
    public void deletePatient(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException(id));

        patientRepository.delete(patient);
    }
}