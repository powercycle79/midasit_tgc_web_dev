package com.creative.eduSurvey.dto;

import com.creative.eduSurvey.entity.Survey;
import lombok.Data;

@Data
public class SurveyDto {
    String age;
    String schoolType;
    String name;
    String phone;
    String orders;
    String agreedFirst;
    String agreedSecond;
    String disagreedFirst;
    String disagreedSecond;
    String opinion;

    static public SurveyDto of(Survey survey) {
        SurveyDto inst = new SurveyDto();
        inst.age = survey.getAge();
        inst.schoolType = survey.getSchool();
        inst.name = survey.getName();
        inst.phone = survey.getPhone();
        inst.orders = survey.getOrders();
        inst.agreedFirst = survey.getAgreedFirst();
        inst.agreedSecond = survey.getAgreedSecond();
        inst.disagreedFirst = survey.getDisagreedFirst();
        inst.disagreedSecond = survey.getDisagreedSecond();
        inst.opinion = survey.getOpinion();
        return inst;
    }


    public Survey toEntity() {
        Survey survey = Survey.create();
        survey.setAge(this.age);
        survey.setSchool(this.schoolType);
        survey.setName(this.name);
        survey.setPhone(this.phone);
        survey.setOrders(this.orders);
        survey.setAgreedFirst(this.agreedFirst);
        survey.setAgreedSecond(this.agreedSecond);
        survey.setDisagreedFirst(this.disagreedFirst);
        survey.setDisagreedSecond(this.disagreedSecond);
        survey.setOpinion(this.opinion);
        return survey;
    }
}
