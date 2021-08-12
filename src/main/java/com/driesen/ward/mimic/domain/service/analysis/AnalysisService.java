package com.driesen.ward.mimic.domain.service.analysis;

import com.driesen.ward.mimic.domain.model.*;
import com.driesen.ward.mimic.domain.model.dto.AgeOccurrence;
import com.driesen.ward.mimic.domain.model.dto.IndividualPatientAdmissionCorrelationDto;
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
    public PatientAdmissionCorrelation findCorrelationBetweenPatientAgeGenderAndAdmissionRateGrouped() {
        List<Patient> male = patientService.findByGender("M");
        List<Patient> female = patientService.findByGender("F");

        return new PatientAdmissionCorrelation(categories, calculateAgesAndGroup(male), calculateAgesAndGroup(female));
    }

    private List<Integer> calculateAgesAndGroup(List<Patient> patients) {
        List<Integer> ages = calculateAgesAndAddToList(patients);
        return groupAndOrderAges(ages);
    }

    private List<Integer> groupAndOrderAges(List<Integer> ages) {
        TreeMap<String, Integer> nbrOfAgesPerCategory =
                new TreeMap<>(ages.stream().collect(Collectors.groupingBy(this::groupAgeCategories, Collectors.summingInt(x -> 1))));

        Arrays.asList(categories).forEach(category -> {
            if(!nbrOfAgesPerCategory.containsKey(category)) {
                nbrOfAgesPerCategory.put(category, 0);
            }
        });

        return new ArrayList<>(nbrOfAgesPerCategory.values());
    }

    private TreeMap<Integer, Integer> getIndividualAgeOccurrences(List<Integer> ages) {
        return new TreeMap<>(ages.stream().collect(Collectors.groupingBy(age -> age, Collectors.summingInt(x -> 1))));
    }

    private String groupAgeCategories(int age) {
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

    @Override
    public IndividualPatientAdmissionCorrelationDto findCorrelationBetweenPatientAgeGenderAndAdmissionRateIndividual() {
        List<Patient> male = patientService.findByGender("M");
        List<Patient> female = patientService.findByGender("F");

        return new IndividualPatientAdmissionCorrelationDto(getAgeOccurrenceWrapper(male), getAgeOccurrenceWrapper(female));
    }

    private List<AgeOccurrence> getAgeOccurrenceWrapper(List<Patient> patients) {
        List<Integer> ages = calculateAgesAndAddToList(patients);
        return transformAgeOccurrencesToList(getIndividualAgeOccurrences(ages));
    }

    private List<AgeOccurrence> transformAgeOccurrencesToList(TreeMap<Integer, Integer> ageOccurrencesMap) {
        List<AgeOccurrence> ageOccurrences = new ArrayList<>();
        ageOccurrencesMap.forEach((k, v) -> {
            ageOccurrences.add(new AgeOccurrence(k, v));
        });

        return ageOccurrences;
    }

    private List<Integer> calculateAgesAndAddToList(List<Patient> patients) {
        List<Integer> ages = new ArrayList<>();
        patients.forEach(patient -> {
            Admission firstAdmission = admissionService.findFirstByPatient(patient.getId());
            int age = calculateAge(firstAdmission, patient);
            if(age == 300) {
                ages.add(generateRandomAge());
            } else {
                ages.add(age);
            }
        });
        return ages;
    }

    private int generateRandomAge() {
        Random random = new Random();
        return random.nextInt(100-90) + 90;
    }

    private int calculateAge(Admission admission, Patient patient) {
        return admission.getAdmitTime().getYear() - patient.getDateOfBirth().getYear();
    }
}
