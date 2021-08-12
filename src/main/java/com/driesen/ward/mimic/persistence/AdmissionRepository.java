package com.driesen.ward.mimic.persistence;

import com.driesen.ward.mimic.domain.model.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<Admission, Integer> {
    Admission findFirstByPatientIdOrderByAdmitTime(int patientId);
}
