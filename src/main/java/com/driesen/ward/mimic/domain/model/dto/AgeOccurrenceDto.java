package com.driesen.ward.mimic.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * AgeOccurrenceDto Dto Object.
 *
 * Used for REST response.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgeOccurrenceDto {
    private int age;
    private int occurrences;
}
