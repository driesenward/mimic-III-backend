package com.driesen.ward.mimic.domain.service.individualAnalysisService;

import com.driesen.ward.mimic.domain.model.calculations.AgeOccurrence;
import com.driesen.ward.mimic.domain.model.calculations.IndividualPatientAdmissionCorrelation;
import com.driesen.ward.mimic.domain.model.entities.Patient;
import com.driesen.ward.mimic.domain.service.ageService.AgeService;
import com.driesen.ward.mimic.domain.service.patient.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/***
 * IndividualAnalysisServiceImpl implemented with the {@link IndividualAnalysisService} interface.
 */
@Service
@RequiredArgsConstructor
public class IndividualAnalysisServiceImpl implements IndividualAnalysisService {
    private final PatientService patientService;
    private final AgeService ageService;

    @Override
    public IndividualPatientAdmissionCorrelation analyseCorrelationPatientAdmission() {
        List<Patient> male = patientService.findByGender("M");
        List<Patient> female = patientService.findByGender("F");

        return new IndividualPatientAdmissionCorrelation(getAgeOccurrences(male), getAgeOccurrences(female));
    }

    /***
     * Calculate ages and count the occurrences for each individual age.
     *
     * @param patients list of patients we want to know the age occurrences from.
     * @return list with age occurrences.
     */
    private List<AgeOccurrence> getAgeOccurrences(List<Patient> patients) {
        List<Integer> ages = ageService.calculateAges(patients);

        TreeMap<Integer, Integer> ageOccurrencesMap =
                new TreeMap<>(ages.stream().collect(Collectors.groupingBy(age -> age, Collectors.summingInt(x -> 1))));

        return transformTreeMapToListOfAgeOccurrences(ageOccurrencesMap);
    }

    /***
     * Transform the TreeMap<Integer, Integer> to a list of AgeOccurrence objects.
     *
     * @param ageOccurrencesMap contains all ages with corresponding occurrences.
     * @return list of age occurrences.
     */
    private List<AgeOccurrence> transformTreeMapToListOfAgeOccurrences(TreeMap<Integer, Integer> ageOccurrencesMap) {
        List<AgeOccurrence> ageOccurrences = new ArrayList<>();

        ageOccurrencesMap.forEach((k, v) -> {
            ageOccurrences.add(new AgeOccurrence(k, v));
        });

        return ageOccurrences;
    }
}
