package com.driesen.ward.mimic.domain.service.patient;

import com.driesen.ward.mimic.domain.model.entities.Patient;
import com.driesen.ward.mimic.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * PatientServiceImpl implemented with {@link PatientService} interface.
 */
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Override
    public List<Patient> findByGender(String gender) {
        return patientRepository.findAllByGender(gender.toUpperCase());
    }
}
