package com.creative.eduSurvey.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Survey {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long sn;
    @Column(
            length = 256,
            nullable = false
    )
    private String orders; //(1,2,3,4) 와 같은 순서, 왼쪽일 수록 긍정적
    @Column(
            length = 128
    )
    private String email;
    @Column(
            length = 128
    )
    private String name;
    @Column(
            length = 128
    )
    private String password;
    @Column(
            length = 128
    )
    private String school; // 학교 유형 (일반학교/특수학교)
    @Column(
            length = 128
    )
    private String age; // 학교 학년
    @Column(
            length = 128
    )
    private String phone; // 핸드폰 번호
    @Column(
            length = 1024
    )
    private String agreedFirst; // 가장 동의하는 항목의 이유
    @Column(
            length = 1024
    )
    private String agreedSecond; // 두번째로 동의하는 항목의 이유
    @Column(
            length = 1024
    )
    private String disagreedFirst; // 가장 비동의하는 항목의 이유
    @Column(
            length = 1024
    )
    private String disagreedSecond; // 두번째로 비동의하는 항목의 이유
    @Column(
            length = 1024
    )
    private String opinion; // 기타 의견
    private Long attention; // 관심 여부

    ////////////////////////////////////////////////////////

    public static Survey create() {
        Survey inst = new Survey();
        return inst;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }
}
