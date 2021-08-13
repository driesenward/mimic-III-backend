package com.driesen.ward.mimic.domain.service.ageService;

import com.driesen.ward.mimic.domain.model.entities.Patient;

import java.util.List;

/***
 * AgeService interface.
 *
 * Contains methods to handle operations regarding age calculations.
 */
public interface AgeService {
    /***
     * Calculate ages for all patients in the given list.
     *
     * @param patients list of patients that we want the ages from.
     * @return a list of ages.
     */
    List<Integer> calculateAges(List<Patient> patients);
}
