package com.driesen.ward.mimic.domain.service.admission;

import com.driesen.ward.mimic.domain.model.entities.Admission;
import com.driesen.ward.mimic.persistence.AdmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/***
 * AdmissionServiceImpl implemented with the {@link AdmissionService} interface.
 */
@Service
@RequiredArgsConstructor
public class AdmissionServiceImpl implements AdmissionService {
    private final AdmissionRepository admissionRepository;

    @Override
    public Admission findFirstByPatient(int patientId) {
        return admissionRepository.findFirstByPatientIdOrderByAdmitTime(patientId);
    }
}
