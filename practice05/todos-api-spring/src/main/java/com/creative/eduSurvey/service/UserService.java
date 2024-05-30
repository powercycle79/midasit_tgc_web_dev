package com.creative.eduSurvey.service;

import com.creative.eduSurvey.dto.QuestionDto;
import com.creative.eduSurvey.dto.RegisterUserDto;
import com.creative.eduSurvey.entity.Question;
import com.creative.eduSurvey.entity.User;
import com.creative.eduSurvey.repository.QuestionRepository;
import com.creative.eduSurvey.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(User user) {
        return userRepository.save(user).getSn();
    }

    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }
}