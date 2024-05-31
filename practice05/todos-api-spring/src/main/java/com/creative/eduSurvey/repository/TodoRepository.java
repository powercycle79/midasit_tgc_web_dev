package com.creative.eduSurvey.repository;

import com.creative.eduSurvey.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Override
    List<Todo> findAll();
}
