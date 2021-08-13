package com.driesen.ward.mimic.domain.service.individualAnalysisService;

import com.driesen.ward.mimic.domain.model.calculations.IndividualPatientAdmissionCorrelation;

/***
 * IndividualAnalysisService interface
 *
 * Contains methods to handle operations regarding analysis which are categorized by age.
 */
public interface IndividualAnalysisService {
    /***
     * Count all the admission occurrences for each age. Results are thus grouped by age.
     *
     * @return IndividualPatientAdmissionCorrelation which contains the occurrences per age for male and female.
     */
    IndividualPatientAdmissionCorrelation analyseCorrelationPatientAdmission();
}
