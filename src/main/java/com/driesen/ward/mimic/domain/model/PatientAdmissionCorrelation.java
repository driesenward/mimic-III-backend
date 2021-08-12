package com.driesen.ward.mimic.domain.model;

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
    private List<Long> male;
    private List<Long> female;
}
