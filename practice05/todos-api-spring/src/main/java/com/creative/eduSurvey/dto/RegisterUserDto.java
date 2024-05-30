package com.creative.eduSurvey.dto;

import com.creative.eduSurvey.entity.User;
import lombok.Data;

@Data
public class RegisterUserDto {
    String id;
    String name;
    String password;
    String school;
    String phone;
}
