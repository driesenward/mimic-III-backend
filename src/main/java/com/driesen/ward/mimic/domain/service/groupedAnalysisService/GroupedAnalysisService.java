package com.driesen.ward.mimic.domain.service.groupedAnalysisService;

import com.driesen.ward.mimic.domain.model.calculations.PatientAdmissionCorrelation;

/***
 * GroupedAnalysisService interface
 *
 * Contains methods to handle operations regarding analysis which are categorized by age category.
 */
public interface GroupedAnalysisService {
    /***
     * Count all the admission occurrences for a certain age category. Results are grouped by age category.
     *
     * @return PatientAdmissionCorrelation which contains the categories and the male/female data.
     */
    PatientAdmissionCorrelation analyseCorrelationPatientAdmission();
}
