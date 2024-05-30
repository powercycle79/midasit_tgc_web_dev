package com.creative.eduSurvey.dto;

import com.creative.eduSurvey.entity.User;
import lombok.Data;

@Data
public class UserDto {
    Long sn;
    String email;
    String name;
    static public UserDto of(User u) {
        UserDto r = new UserDto();
        r.sn = u.getSn();
        r.email = u.getEmail();
        r.name = u.getName();
        return r;
    }
}
