package com.driesen.ward.mimic.domain.service.admission;

import com.driesen.ward.mimic.domain.model.entities.Admission;

/***
 * AdmissionService interface.
 *
 * Contains methods to handle operations regarding admissions.
 */
public interface AdmissionService {
    /***
     * Retrieves the first admission from a certain patient.
     *
     * @param patientId ID of the patient.
     * @return Admission object if there is an admission for that patient.
     */
    Admission findFirstByPatient(int patientId);
}
