package com.driesen.ward.mimic.domain.service.groupedAnalysisService;

import com.driesen.ward.mimic.domain.model.calculations.AgeGroup;
import com.driesen.ward.mimic.domain.model.calculations.PatientAdmissionCorrelation;
import com.driesen.ward.mimic.domain.model.entities.Patient;
import com.driesen.ward.mimic.domain.service.ageService.AgeService;
import com.driesen.ward.mimic.domain.service.patient.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/***
 * GroupedAnalysisServiceImpl implemented with the {@link GroupedAnalysisService} interface.
 */
@Service
@RequiredArgsConstructor
public class GroupedAnalysisServiceImpl implements GroupedAnalysisService {
    private final PatientService patientService;
    private final AgeService ageService;

    /***
     * All the age categories are stored as a String[]
     */
    private final String[] ageCategories = {
            AgeGroup.TEENS.toString(),
            AgeGroup.TWENTIES.toString(),
            AgeGroup.THIRTIES.toString(),
            AgeGroup.FORTIES.toString(),
            AgeGroup.FIFTIES.toString(),
            AgeGroup.SIXTIES.toString(),
            AgeGroup.SEVENTIES.toString(),
            AgeGroup.EIGHTIES.toString(),
            AgeGroup.NINETIES.toString(),
    };

    @Override
    public PatientAdmissionCorrelation analyseCorrelationPatientAdmission() {
        List<Patient> male = patientService.findByGender("M");
        List<Patient> female = patientService.findByGender("F");

        return new PatientAdmissionCorrelation(ageCategories, calculateValues(male), calculateValues(female));
    }

    /***
     * Calculate the ages and count occurrences by age category.
     *
     * @param patients list of patients we want to calculate and group ages from.
     * @return list of occurrences in each specified age category (ordered and sorted by age category).
     */
    private List<Integer> calculateValues(List<Patient> patients) {
        List<Integer> ages = ageService.calculateAges(patients);
        return countOccurrencesPerAgeCategory(ages);
    }

    /***
     * Group the list of ages to their corresponding age category and count the occurrences.
     *
     * @param ages list of ages we want to categorize and count occurrences from.
     * @return list of occurrences in each specified age category (ordered and sorted by age category).
     */
    private List<Integer> countOccurrencesPerAgeCategory(List<Integer> ages) {
        TreeMap<String, Integer> groupedAges =
                new TreeMap<>(ages.stream().collect(Collectors.groupingBy(this::groupAgePerCategory, Collectors.summingInt(x -> 1))));

        addZeroToEmptyCategories(groupedAges);

        return new ArrayList<>(groupedAges.values());
    }

    /***
     * Fill empty categories with 0 counts.
     *
     * @param groupedAges categories with corresponding occurrences.
     */
    private void addZeroToEmptyCategories(TreeMap<String, Integer> groupedAges) {
        Arrays.asList(ageCategories).forEach(category -> {
            if(!groupedAges.containsKey(category)) {
                groupedAges.put(category, 0);
            }
        });
    }

    /***
     * Return the category based on age.
     *
     * @param age age which has to be categorized.
     * @return category where age is categorized.
     */
    private String groupAgePerCategory(int age) {
        if(age < 20)
            return AgeGroup.TEENS.toString();
        if(age < 30)
            return AgeGroup.TWENTIES.toString();
        if(age < 40)
            return AgeGroup.THIRTIES.toString();
        if(age < 50)
            return AgeGroup.FORTIES.toString();
        if(age < 60)
            return AgeGroup.FIFTIES.toString();
        if(age < 70)
            return AgeGroup.SIXTIES.toString();
        if(age < 80)
            return AgeGroup.SEVENTIES.toString();
        if(age < 90)
            return AgeGroup.EIGHTIES.toString();

        return AgeGroup.NINETIES.toString();
    }
}
