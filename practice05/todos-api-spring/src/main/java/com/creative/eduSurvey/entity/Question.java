package com.creative.eduSurvey.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Question {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long sn;
    @Column(
            length = 512,
            nullable = false
    )
    private String statement;
    @Column
    private Boolean isActive;

    ////////////////////////////////////////////////////////

    public static Question create(String statement) {
        Question inst = new Question();
        inst.statement = statement;
        inst.isActive = false;
        return inst;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
