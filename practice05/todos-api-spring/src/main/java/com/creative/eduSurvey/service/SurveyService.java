package com.creative.eduSurvey.service;

import com.creative.eduSurvey.dto.SurveyDto;
import com.creative.eduSurvey.entity.Survey;
import com.creative.eduSurvey.repository.SurveyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class SurveyService {
    private final SurveyRepository surveyRepository;

    public List<SurveyDto> findAll() {
        return surveyRepository.findAll().stream()
                .map(SurveyDto::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(SurveyDto dto) {
        Survey entity = dto.toEntity();
        surveyRepository.save(entity);
    }
}