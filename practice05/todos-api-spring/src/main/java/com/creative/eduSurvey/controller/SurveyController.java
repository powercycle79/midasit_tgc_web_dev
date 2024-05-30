package com.creative.eduSurvey.controller;

import com.creative.eduSurvey.dto.SurveyDto;
import com.creative.eduSurvey.service.SurveyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SurveyController {
    private final SurveyService surveyService;
    private final String password = "01036965338";

    @GetMapping(value = "/surveys", headers = "PASSWORD")
    public List<SurveyDto> GetSurvey(@RequestHeader("PASSWORD") String pw) {
        if(!pw.equals(password)) throw new RuntimeException("Wrong Password");

        return surveyService.findAll();
    }

    @PostMapping(value = "/surveys")
    public void postSurvey(@RequestBody SurveyDto dto) {
        surveyService.save(dto);
    }
}
