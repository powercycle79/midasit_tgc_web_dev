package com.creative.eduSurvey.controller;

import com.creative.eduSurvey.dto.LoginDto;
import com.creative.eduSurvey.dto.RegisterUserDto;
import com.creative.eduSurvey.dto.UserDto;
import com.creative.eduSurvey.entity.User;
import com.creative.eduSurvey.repository.UserRepository;
import com.creative.eduSurvey.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users/{email}")
    public UserDto getUser(@PathVariable String email) {
        User user = userService.getByEmail(email);
        return UserDto.of(user);
    }

    @PostMapping("/users")
    public Long postUser(@RequestBody RegisterUserDto user) {
        User u = User.register(user.getId());
        u.setName(user.getName());
        u.setSchool(user.getSchool());
        u.setPhone(user.getPhone());
        u.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.save(u);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody LoginDto loginDto) {
        User user = userService.getByEmail(loginDto.getId());
        if(passwordEncoder.matches(loginDto.getPw(), user.getPassword())) {
            return UserDto.of(user);
        }
        throw new RuntimeException();
    }
}
