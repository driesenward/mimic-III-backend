package com.driesen.ward.mimic.domain.model.calculations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/***
 * IndividualPatientAdmissionCorrelation Model Object.
 *
 * Contains a list of all the age occurrences for male and female.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndividualPatientAdmissionCorrelation {
    private List<AgeOccurrence> male;
    private List<AgeOccurrence> female;
}
