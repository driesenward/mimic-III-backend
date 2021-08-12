package com.driesen.ward.mimic.persistence;

import com.driesen.ward.mimic.domain.model.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findAllByGender(String gender);
}
