package com.shTest.entity;

import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.dto.EquipmentUsingDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Equipment_Log")
@Getter
@SequenceGenerator(
        name = "SEQ_EQP_LOG",
        sequenceName = "SEQ_EQP_LOG",
        initialValue = 441,
        allocationSize = 1
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class EquipmentUsing {

    @Id
    @Column(name = "LOG_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_EQP_LOG")
    private int logNo;

    @Column(name = "MEM_NO")
    private int memNo = 71;

    // 담당자 번호
    @Column(name = "REQ_DT")
    private Date reqDt = new Date();

    @Column(name = "USE_STRT_DT")
    private Date useStrtDt;

    @Column(name = "RTN_ESTMT_DT")
    private Date rtnEstmtDt;

    @Column(name = "RTN_DT")
    private Date rtnDt;

    @Column(name = "USE_FOR")
    private String useFor;

    @Column(name = "EQPMNT_NO")
    private int eqpNo;

    @Column(name = "ch_no")
    private int chNo = 95;

    @Column(name = "th_no")
    private int thNo = 332;

    public EquipmentUsing(EquipmentUsingDto eqpUsingDto) {
        this.logNo = eqpUsingDto.getLogNo();
        this.useStrtDt = eqpUsingDto.getUseStrtDt();
        this.rtnEstmtDt = eqpUsingDto.getRtnEstmtDt();
        this.rtnDt = eqpUsingDto.getRtnDt();
        this.useFor = eqpUsingDto.getUseFor();
        this.eqpNo = eqpUsingDto.getEqpNo();
    }

    public void EquipmentUsingBroken() {
        this.rtnDt = new Date();
    }
}
