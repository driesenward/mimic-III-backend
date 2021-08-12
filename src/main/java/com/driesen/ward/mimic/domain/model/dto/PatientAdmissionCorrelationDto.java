package com.driesen.ward.mimic.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientAdmissionCorrelationDto {
    private String[] categories;
    private List<Integer> male;
    private List<Integer> female;
}
