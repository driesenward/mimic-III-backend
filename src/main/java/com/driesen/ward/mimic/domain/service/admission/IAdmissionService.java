package com.driesen.ward.mimic.domain.service.admission;

import com.driesen.ward.mimic.domain.model.entities.Admission;

public interface IAdmissionService {
    Admission findFirstByPatient(int patientId);
}
