package com.creative.eduSurvey.service;

import com.creative.eduSurvey.dto.QuestionDto;
import com.creative.eduSurvey.entity.Question;
import com.creative.eduSurvey.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<QuestionDto> findAll() {
        return questionRepository.findAll().stream()
                .map(QuestionDto::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(QuestionDto dto) {
        Question q = Question.create(dto.getStatement());
        q.setIsActive(Boolean.TRUE);
        questionRepository.save(q);
    }

    @Transactional
    public void delete(Long sn) {
        Question q = questionRepository.findById(sn).orElseThrow();
        questionRepository.delete(q);
    }

    @Transactional
    public void patch(QuestionDto dto) {
        Question q = questionRepository.findById(dto.getSn()).orElseThrow();
        Optional.ofNullable(dto.getStatement()).ifPresent(q::setStatement);
        Optional.ofNullable(dto.getIsActive()).ifPresent(q::setIsActive);
    }
}