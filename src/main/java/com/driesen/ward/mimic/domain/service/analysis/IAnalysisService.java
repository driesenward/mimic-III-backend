package com.driesen.ward.mimic.domain.service.analysis;

import com.driesen.ward.mimic.domain.model.PatientAdmissionCorrelation;
import com.driesen.ward.mimic.domain.model.dto.IndividualPatientAdmissionCorrelationDto;

public interface IAnalysisService {
    PatientAdmissionCorrelation findCorrelationBetweenPatientAgeGenderAndAdmissionRateGrouped();
    IndividualPatientAdmissionCorrelationDto findCorrelationBetweenPatientAgeGenderAndAdmissionRateIndividual();
}
