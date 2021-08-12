package com.driesen.ward.mimic.domain.service.admission;

import com.driesen.ward.mimic.domain.model.Admission;
import com.driesen.ward.mimic.persistence.AdmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdmissionService implements IAdmissionService {
    private final AdmissionRepository admissionRepository;

    @Override
    public Admission findFirstByPatient(int patientId) {
        return admissionRepository.findFirstByPatientIdOrderByAdmitTime(patientId);
    }
}
