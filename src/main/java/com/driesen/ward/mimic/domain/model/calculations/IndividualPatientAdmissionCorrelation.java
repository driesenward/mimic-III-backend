package com.driesen.ward.mimic.domain.model.calculations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndividualPatientAdmissionCorrelation {
    private List<AgeOccurrence> male;
    private List<AgeOccurrence> female;
}
