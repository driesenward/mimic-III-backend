package com.driesen.ward.mimic.controller;

import com.driesen.ward.mimic.domain.model.dto.IndividualPatientAdmissionCorrelationDto;
import com.driesen.ward.mimic.domain.model.dto.PatientAdmissionCorrelationDto;
import com.driesen.ward.mimic.domain.service.analysis.IAnalysisService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("analysis")
@RequiredArgsConstructor
public class TestController {
    private final IAnalysisService analysisService;
    private final ModelMapper modelMapper;

    @GetMapping("grouped")
    public PatientAdmissionCorrelationDto analyseCorrelationPatientAgeGenderAdmissionGrouped() {
        return modelMapper.map(
                analysisService.findCorrelationBetweenPatientAgeGenderAndAdmissionRateGrouped(),
                PatientAdmissionCorrelationDto.class);
    }

    @GetMapping("individual")
    public IndividualPatientAdmissionCorrelationDto analyseCorrelationPatientAgeGenderAdmissionIndividual() {
        return modelMapper.map(
                analysisService.findCorrelationBetweenPatientAgeGenderAndAdmissionRateIndividual(),
                IndividualPatientAdmissionCorrelationDto.class);
    }
}
