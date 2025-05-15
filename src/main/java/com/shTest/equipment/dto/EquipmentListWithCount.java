package com.shTest.equipment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentListWithCount {
    private List<EquipmentDto> eqpList;
    private int numberOfElements;

    public EquipmentListWithCount(List<EquipmentDto> eqpList, int numberOfElements) {
        this.eqpList = eqpList;
        this.numberOfElements = numberOfElements;
    }
}
