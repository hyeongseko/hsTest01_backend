package com.shTest.equipment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentDto {
    private int eqpNo;
    private String eqpNm;
    private String eqpUsing;
    private String eqpDelyn;

    // 담당자 번호 및 이름
    private int eqpmngr;
    private String chMemNm;


    // 만든 날짜
    private Date eqpDt;
    // 사용 기한
    private Date eqpDue;
    private String eqpContent;

    // 카테고리
    private int eqpCateNo;
    private String eqpCateNm;
    private EquipmentCateDto eqpCateDto;

    private int chNo;
    private int thNO;
    private String thTtl;

    private String keyWordGubun;
    private String keyWord;

    // 파일 정보들
    private AtchFileDto atchFileDto;

    // 대여 정보
    private EquipmentUsingDto eqpUsingDto;


}
