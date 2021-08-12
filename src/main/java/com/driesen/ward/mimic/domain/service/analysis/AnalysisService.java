package com.driesen.ward.mimic.domain.service.analysis;

import com.driesen.ward.mimic.domain.model.AgeGroup;
import com.driesen.ward.mimic.domain.model.Patient;
import com.driesen.ward.mimic.domain.model.PatientAdmissionCorrelation;
import com.driesen.ward.mimic.domain.service.admission.IAdmissionService;
import com.driesen.ward.mimic.domain.service.patient.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalysisService implements IAnalysisService {
    private final IPatientService patientService;
    private final IAdmissionService admissionService;

    private final String[] categories = {
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
    public PatientAdmissionCorrelation findCorrelationBetweenPatientAgeGenderAndAdmissionRate() {
        List<Patient> male = patientService.findByGender("M");
        List<Patient> female = patientService.findByGender("F");

        List<Long> nbrOfAgesPerCategoryMale = getNbrPerAgeCategory(male);
        List<Long> nbrOfAgesPerCategoryFemale = getNbrPerAgeCategory(female);

        return new PatientAdmissionCorrelation(categories, nbrOfAgesPerCategoryMale, nbrOfAgesPerCategoryFemale);
    }

    private List<Long> getNbrPerAgeCategory(List<Patient> patients) {
        List<Integer> ages = new ArrayList<>();
        patients.forEach(patient -> {
            int admitYear = admissionService.findFirstByPatient(patient.getId()).getAdmitTime().getYear();
            ages.add(admitYear - patient.getDateOfBirth().getYear());
        });

        TreeMap<String, Long> nbrOfAgesPerCategory = new TreeMap<>(ages.stream().collect(Collectors.groupingBy(this::group, Collectors.counting())));

        Arrays.asList(categories).forEach(category -> {
            if(!nbrOfAgesPerCategory.containsKey(category)) {
                nbrOfAgesPerCategory.put(category, 0L);
            }
        });

        return new ArrayList<>(nbrOfAgesPerCategory.values());
    }

    private String group(int age) {
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
        if(age > 90)
            return AgeGroup.NINETIES.toString();

        return null;
    }
}
