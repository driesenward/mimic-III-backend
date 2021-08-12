package com.driesen.ward.mimic.domain.service.patient;

import com.driesen.ward.mimic.domain.model.entities.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> findByGender(String gender);
}
