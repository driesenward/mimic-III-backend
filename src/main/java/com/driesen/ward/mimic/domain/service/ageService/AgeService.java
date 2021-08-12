package com.driesen.ward.mimic.domain.service.ageService;

import com.driesen.ward.mimic.domain.model.entities.Admission;
import com.driesen.ward.mimic.domain.model.entities.Patient;
import com.driesen.ward.mimic.domain.service.admission.IAdmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AgeService implements IAgeService {
    private final IAdmissionService admissionService;

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

    private int calculateAge(Admission admission, Patient patient) {
        return admission.getAdmitTime().getYear() - patient.getDateOfBirth().getYear();
    }

    private int generateRandomAge() {
        return new Random().nextInt(100-90) + 90;
    }
}
