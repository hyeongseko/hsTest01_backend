package com.shTest.equipment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentUsingDto {
    private int logNo;
    private Date useStrtDt;
    private Date rtnEstmtDt;
    private Date rtnDt;
    private String useFor;
    private int eqpNo;
}
