package com.shTest.equipment.repository;

import com.shTest.entity.Equipment;
import com.shTest.equipment.dto.EquipmentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EquipmentCustomRepository {
    Page<EquipmentDto> eqpList(String keyWord , int tag, Pageable pageable);
    List<EquipmentDto> eqpCateList(String keyWord);
    Integer eqpCateNoFind(String keyWord);
}
