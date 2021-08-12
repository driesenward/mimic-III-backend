package com.driesen.ward.mimic.domain.service.individualAnalysisService;

import com.driesen.ward.mimic.domain.model.calculations.IndividualPatientAdmissionCorrelation;

public interface IIndividualAnalysisService {
    IndividualPatientAdmissionCorrelation analyseCorrelationPatientAdmission();
}
