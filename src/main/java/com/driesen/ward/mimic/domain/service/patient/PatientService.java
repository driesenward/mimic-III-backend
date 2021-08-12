package com.driesen.ward.mimic.domain.service.patient;

import com.driesen.ward.mimic.domain.model.Patient;
import com.driesen.ward.mimic.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService implements IPatientService {
    private final PatientRepository patientRepository;

    @Override
    public List<Patient> findByGender(String gender) {
        return patientRepository.findAllByGender(gender.toUpperCase());
    }
}
