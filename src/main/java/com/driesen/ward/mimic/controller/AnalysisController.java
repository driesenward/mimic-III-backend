package com.driesen.ward.mimic.controller;

import com.driesen.ward.mimic.domain.model.dto.IndividualPatientAdmissionCorrelationDto;
import com.driesen.ward.mimic.domain.model.dto.PatientAdmissionCorrelationDto;
import com.driesen.ward.mimic.domain.service.groupedAnalysisService.GroupedAnalysisService;
import com.driesen.ward.mimic.domain.service.individualAnalysisService.IndividualAnalysisService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * AnalysisController controller.
 *
 * Contains and handles incoming API calls for analyzing data (from the database).
 */
@RestController
@RequestMapping("analysis")
@RequiredArgsConstructor
public class AnalysisController {
    private final GroupedAnalysisService groupedAnalysisService;
    private final IndividualAnalysisService individualAnalysisService;
    private final ModelMapper modelMapper;

    /***
     * REST endpoint to obtain the correlation between patients age-gender and the admission rate.
     * Count all the admission occurrences for a certain age category. Results are grouped by age category.
     *
     * @return PatientAdmissionCorrelationDto which contains the age categories and the corresponding data.
     */
    @GetMapping("grouped")
    public PatientAdmissionCorrelationDto analyseCorrelationPatientAgeGenderAdmissionGrouped() {
        return modelMapper.map(
                groupedAnalysisService.analyseCorrelationPatientAdmission(),
                PatientAdmissionCorrelationDto.class);
    }

    /***
     * REST endpoint to obtain the correlation between patients age-gender and the admission rate.
     * Count all the admission occurrences for a certain age. Results are individual.
     *
     * @return IndividualPatientAdmissionCorrelationDto which contains a list for admission occurrences by age for both male and female.
     */
    @GetMapping("individual")
    public IndividualPatientAdmissionCorrelationDto analyseCorrelationPatientAgeGenderAdmissionIndividual() {
        return modelMapper.map(
                individualAnalysisService.analyseCorrelationPatientAdmission(),
                IndividualPatientAdmissionCorrelationDto.class);
    }
}
