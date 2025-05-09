package com.shTest.equipment.repository;

import com.shTest.entity.Equipment;
import com.shTest.equipment.dto.EquipmentDto;

import java.util.List;

public interface EquipmentCustomRepository {
    List<EquipmentDto> eqpList(String keyWord);
    List<EquipmentDto> eqpCateList();
}
