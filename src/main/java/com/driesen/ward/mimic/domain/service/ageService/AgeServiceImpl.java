package com.driesen.ward.mimic.domain.service.ageService;

import com.driesen.ward.mimic.domain.model.entities.Admission;
import com.driesen.ward.mimic.domain.model.entities.Patient;
import com.driesen.ward.mimic.domain.service.admission.AdmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AgeServiceImpl implements AgeService {
    private final AdmissionService admissionService;

    @Override
    public List<Integer> calculateAges(List<Patient> patients) {
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

    /***
     * !!! IMPORTANT !!!
     * AGES WERE DISTORTED IN THE MIMIC-III DATASET
     *
     * Calculate the patients age on the moment of the specified admission.
     *
     * @param admission the first admission from the specified patient.
     * @param patient patient that we want to know the age from.
     * @return calculated age.
     */
    private int calculateAge(Admission admission, Patient patient) {
        return admission.getAdmitTime().getYear() - patient.getDateOfBirth().getYear();
    }

    /***
     * Generate a random age between 90 and 100.
     *
     * @return random age.
     */
    private int generateRandomAge() {
        return new Random().nextInt(100-90) + 90;
    }
}
