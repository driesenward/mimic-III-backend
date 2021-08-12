package com.driesen.ward.mimic.domain.service.analysis;

import com.driesen.ward.mimic.domain.model.PatientAdmissionCorrelation;

public interface IAnalysisService {
    PatientAdmissionCorrelation findCorrelationBetweenPatientAgeGenderAndAdmissionRate();
}
