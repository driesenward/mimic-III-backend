package com.driesen.ward.mimic.domain.service.individualAnalysisService;

import com.driesen.ward.mimic.domain.model.calculations.AgeOccurrence;
import com.driesen.ward.mimic.domain.model.calculations.IndividualPatientAdmissionCorrelation;
import com.driesen.ward.mimic.domain.model.entities.Patient;
import com.driesen.ward.mimic.domain.service.ageService.IAgeService;
import com.driesen.ward.mimic.domain.service.patient.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualIndividualAnalysisService implements IIndividualAnalysisService {
    private final IPatientService patientService;
    private final IAgeService ageService;

    @Override
    public IndividualPatientAdmissionCorrelation analyseCorrelationPatientAdmission() {
        List<Patient> male = patientService.findByGender("M");
        List<Patient> female = patientService.findByGender("F");

        return new IndividualPatientAdmissionCorrelation(getAgeOccurrences(male), getAgeOccurrences(female));
    }

    private List<AgeOccurrence> getAgeOccurrences(List<Patient> patients) {
        List<Integer> ages = ageService.calculateAges(patients);

        TreeMap<Integer, Integer> ageOccurrencesMap =
                new TreeMap<>(ages.stream().collect(Collectors.groupingBy(age -> age, Collectors.summingInt(x -> 1))));

        return transformTreeMapToListOfAgeOccurrences(ageOccurrencesMap);
    }

    private List<AgeOccurrence> transformTreeMapToListOfAgeOccurrences(TreeMap<Integer, Integer> ageOccurrencesMap) {
        List<AgeOccurrence> ageOccurrences = new ArrayList<>();

        ageOccurrencesMap.forEach((k, v) -> {
            ageOccurrences.add(new AgeOccurrence(k, v));
        });

        return ageOccurrences;
    }
}
