package com.driesen.ward.mimic.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/***
 * IndividualPatientAdmissionCorrelationDto Dto Object.
 *
 * Used for REST response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndividualPatientAdmissionCorrelationDto {
    private List<AgeOccurrenceDto> male;
    private List<AgeOccurrenceDto> female;
}
