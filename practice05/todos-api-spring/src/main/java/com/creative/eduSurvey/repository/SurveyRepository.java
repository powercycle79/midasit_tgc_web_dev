package com.creative.eduSurvey.repository;

import com.creative.eduSurvey.entity.Survey;
import com.creative.eduSurvey.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> findAll();
}
