package com.driesen.ward.mimic.domain.model.calculations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/***
 * PatientAdmissionCorrelation Model Object.
 *
 * Contains all the age categories and corresponding occurrences for those categories for male and female.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientAdmissionCorrelation {
    private String[] categories;
    private List<Integer> male;
    private List<Integer> female;
}
