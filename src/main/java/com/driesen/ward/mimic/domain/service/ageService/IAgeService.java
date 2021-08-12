package com.driesen.ward.mimic.domain.service.ageService;

import com.driesen.ward.mimic.domain.model.entities.Patient;

import java.util.List;

public interface IAgeService {
    List<Integer> calculateAges(List<Patient> patients);
}
