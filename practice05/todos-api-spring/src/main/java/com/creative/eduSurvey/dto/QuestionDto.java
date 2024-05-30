package com.creative.eduSurvey.dto;

import com.creative.eduSurvey.entity.Question;
import lombok.Data;

@Data
public class QuestionDto {
    Long sn;
    String statement;
    Boolean isActive;
    static public QuestionDto of(Question q) {
        QuestionDto r = new QuestionDto();
        r.setSn(q.getSn());
        r.setIsActive(q.getIsActive());
        r.setStatement(q.getStatement());
        return r;
    }
}
