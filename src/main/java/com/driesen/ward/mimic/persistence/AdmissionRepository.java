package com.driesen.ward.mimic.persistence;

import com.driesen.ward.mimic.domain.model.entities.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * AdmissionRepository repository class implemented with the {@link JpaRepository} interface.
 *
 * Contains methods to query the table - admissions
 */
public interface AdmissionRepository extends JpaRepository<Admission, Integer> {
    /***
     * Fetch the first admission from a certain patient.
     *
     * @param patientId id from the patient we want to fetch the first admission from.
     * @return first admission from the patient.
     */
    Admission findFirstByPatientIdOrderByAdmitTime(int patientId);
}
