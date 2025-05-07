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
    private long eqpNo;
    private String eqpNm;
    // 담당자 번호
    private long eqpmngr;
    private long eqpUsing;
    // 만든 날짜
    private Date eqpDt;
    // 사용 기한
    private Date eqpDue;
    private long eqpFildId;
    private String eqpContent;
    private long eqpSortNo;
    private String eqpDelyn;

    public EquipmentDto(Equipment eqp) {
        this.eqpNo = eqp.getEqpNo();
        this.eqpNm = eqp.getEqpNm();
        this.eqpmngr = eqp.getEqpmngr();
        this.eqpUsing = eqp.getEqpUsing();
        this.eqpDt = eqp.getEqpDt();
        this.eqpDue = eqp.getEqpDue();
        this.eqpFildId = eqp.getEqpFildId();
        this.eqpContent = eqp.getEqpContent();
        this.eqpSortNo = eqp.getEqpSortNo();
        this.eqpDelyn = eqp.getEqpDelyn();
    }
}
