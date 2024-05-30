package com.creative.eduSurvey.repository;

import com.creative.eduSurvey.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    List<User> findAll();
    User getByEmail(String email);
}
