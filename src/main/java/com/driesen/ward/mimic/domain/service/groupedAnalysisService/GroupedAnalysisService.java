package com.driesen.ward.mimic.domain.service.groupedAnalysisService;

import com.driesen.ward.mimic.domain.model.calculations.AgeGroup;
import com.driesen.ward.mimic.domain.model.calculations.PatientAdmissionCorrelation;
import com.driesen.ward.mimic.domain.model.entities.Patient;
import com.driesen.ward.mimic.domain.service.ageService.IAgeService;
import com.driesen.ward.mimic.domain.service.patient.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupedAnalysisService implements IGroupedAnalysisService {
    private final IPatientService patientService;
    private final IAgeService ageService;

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

    private List<Integer> calculateValues(List<Patient> patients) {
        List<Integer> ages = ageService.calculateAges(patients);
        return groupAges(ages);
    }

    private List<Integer> groupAges(List<Integer> ages) {
        TreeMap<String, Integer> groupedAges =
                new TreeMap<>(ages.stream().collect(Collectors.groupingBy(this::groupAgePerCategory, Collectors.summingInt(x -> 1))));

        addZeroToEmptyCategories(groupedAges);

        return new ArrayList<>(groupedAges.values());
    }

    private void addZeroToEmptyCategories(TreeMap<String, Integer> groupedAges) {
        Arrays.asList(ageCategories).forEach(category -> {
            if(!groupedAges.containsKey(category)) {
                groupedAges.put(category, 0);
            }
        });
    }

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
