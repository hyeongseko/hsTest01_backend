package com.shTest.equipment.dto;

import com.shTest.entity.EquipmentSort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentSortDto {

    private long eqpCateNo;

    private String eqpCateNm;

    private String eqpCateDelyn;

    public EquipmentSortDto(EquipmentSort eqpSort) {
        this.eqpCateNo = eqpSort.getEqpCateNo();
        this.eqpCateNm = eqpSort.getEqpCateNm();
        this.eqpCateDelyn = eqpSort.getEqpCateDelyn();
    }
}
