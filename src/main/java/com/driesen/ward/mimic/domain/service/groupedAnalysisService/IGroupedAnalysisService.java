package com.driesen.ward.mimic.domain.service.groupedAnalysisService;

import com.driesen.ward.mimic.domain.model.calculations.PatientAdmissionCorrelation;

public interface IGroupedAnalysisService {
    PatientAdmissionCorrelation analyseCorrelationPatientAdmission();
}
