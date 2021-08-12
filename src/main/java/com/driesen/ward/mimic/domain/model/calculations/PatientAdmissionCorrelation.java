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
public class PatientAdmissionCorrelation {
    private String[] categories;
    private List<Integer> male;
    private List<Integer> female;
}
