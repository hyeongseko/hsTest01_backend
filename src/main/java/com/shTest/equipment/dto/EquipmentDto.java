package com.shTest.equipment.dto;

import com.shTest.entity.Equipment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentDto {
    private int eqpNo;
    private String eqpNm;

    // 담당자 번호 및 이름
    private int eqpmngr;
    private String chMemNm;

    private int eqpUsing;
    // 만든 날짜
    private Date eqpDt;
    // 사용 기한
    private Date eqpDue;
    private int eqpFildId;
    private String eqpContent;

    // 카테고리
    private int eqpCateNo;
    private String eqpCateNm;
    private String eqpCateDelyn;

    private String eqpDelyn;

    private int chNo;
    private int thNO;
    private String thTtl;

    private String keyWord;

    private int numberOfElements;
    
    // 파일 정보들
    private int atchDetailFileId;
    private String atchFilePath;
    private String atchFileExtn;
    private String atchFileOrginNm;
}
