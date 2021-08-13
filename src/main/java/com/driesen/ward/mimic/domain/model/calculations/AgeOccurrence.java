package com.driesen.ward.mimic.domain.model.calculations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * AgeOccurrence Model Object.
 *
 * Attributes to represent the amount of occurrences per age.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgeOccurrence {
    private int age;
    private int occurrences;
}
