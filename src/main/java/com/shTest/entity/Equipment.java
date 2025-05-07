package com.shTest.entity;

import com.shTest.equipment.dto.EquipmentDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Equipment")
@Getter
@SequenceGenerator(
        name = "SEQ_EQP",
        sequenceName = "SEQ_EQP",
        initialValue = 181,
        allocationSize = 1
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Equipment {

    @Id
    @Column(name = "eqpmnt_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_EQP")
    private long eqpNo;

    @Column(name = "eqpmnt_nm")
    private String eqpNm;

    // 담당자 번호
    @Column(name = "eqpmnt_mngr")
    private long eqpmngr;

    @Column(name = "eqpmnt_using")
    private long eqpUsing;

    @Column(name = "eqpmnt_dt")
    private Date eqpDt;

    // 사용 기한
    @Column(name = "eqpmnt_due")
    private Date eqpDue;

    @Column(name = "EQPMNT_ATCH_FILE_ID")
    private long eqpFildId;

    @Column(name = "eqpmnt_content")
    private String eqpContent;

    @Column(name = "eqpmnt_sort_no")
    private long eqpSortNo;

    @Column(name = "eqpmnt_delyn")
    private String eqpDelyn;

    public Equipment(EquipmentDto eqpDto) {
        this.eqpNo = eqpDto.getEqpNo();
        this.eqpNm = eqpDto.getEqpNm();
        this.eqpmngr = eqpDto.getEqpmngr();
        this.eqpUsing = eqpDto.getEqpUsing();
        this.eqpDt = eqpDto.getEqpDt();
        this.eqpDue = eqpDto.getEqpDue();
        this.eqpFildId = eqpDto.getEqpFildId();
        this.eqpContent = eqpDto.getEqpContent();
        this.eqpSortNo = eqpDto.getEqpSortNo();
        this.eqpDelyn = eqpDto.getEqpDelyn();
    }
}
