package com.driesen.ward.mimic.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/***
 * PatientAdmissionCorrelationDto Dto Object.
 *
 * Used for REST response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientAdmissionCorrelationDto {
    private String[] categories;
    private List<Integer> male;
    private List<Integer> female;
}
