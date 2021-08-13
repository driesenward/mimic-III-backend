package com.driesen.ward.mimic.persistence;

import com.driesen.ward.mimic.domain.model.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/***
 * PatientRepository repository class implemented with the {@link JpaRepository} interface.
 *
 * Contains methods to query the table - patients
 */
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    /***
     * Fetch all the patients based on a gender.
     *
     * @param gender gender value (for now only M/F is supported).
     * @return list of patients from a certain gender.
     */
    List<Patient> findAllByGender(String gender);
}
