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

    private int eqpCateNo;
    private String eqpCateNm;

    private String eqpDelyn;

    private int chNo;
    private int thNO;
    private String thTtl;

    private String eqpCateDelyn;


    private String keyWord;

    public EquipmentDto(Equipment eqp) {
        this.eqpNo = eqp.getEqpNo();
        this.eqpNm = eqp.getEqpNm();
        this.eqpmngr = eqp.getEqpmngr();
        this.eqpUsing = eqp.getEqpUsing();
        this.eqpDt = eqp.getEqpDt();
        this.eqpDue = eqp.getEqpDue();
        this.eqpFildId = eqp.getEqpFildId();
        this.eqpContent = eqp.getEqpContent();
        this.eqpCateNo = eqp.getEqpCateNo();
        this.eqpDelyn = eqp.getEqpDelyn();
        this.chNo = eqp.getChNo();
        this.thNO = eqp.getThNo();
        this.eqpCateDelyn = eqp.getEqpDelyn();
    }
}
