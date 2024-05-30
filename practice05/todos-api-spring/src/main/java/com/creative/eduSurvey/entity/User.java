package com.creative.eduSurvey.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long sn;
    @Column(
            length = 128,
            nullable = false,
            unique = true
    )
    private String email;
    @Column(
            length = 128,
            nullable = false
    )
    private String name;
    @Column(
            length = 128,
            nullable = false
    )
    private String password;
    @Column(
            length = 128,
            nullable = false
    )
    private String school;
    @Column(
            length = 128,
            nullable = false
    )
    private String phone;

    ////////////////////////////////////////////////////////

    public static User register(String email) {
        User user = new User();
        user.email = email;
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
