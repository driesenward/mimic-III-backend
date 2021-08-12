package com.driesen.ward.mimic.domain.service.admission;

import com.driesen.ward.mimic.domain.model.Admission;

public interface IAdmissionService {
    Admission findFirstByPatient(int patientId);
}
