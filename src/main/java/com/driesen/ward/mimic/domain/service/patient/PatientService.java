package com.driesen.ward.mimic.domain.service.patient;

import com.driesen.ward.mimic.domain.model.entities.Patient;

import java.util.List;

/***
 * PatientService interface.
 *
 * Contains methods to handle operations regarding patients.
 */
public interface PatientService {
    /***
     * Find all patients based on a gender.
     *
     * @param gender gender value (for now only M/F is supported).
     * @return list of patients from a certain gender.
     */
    List<Patient> findByGender(String gender);
}
