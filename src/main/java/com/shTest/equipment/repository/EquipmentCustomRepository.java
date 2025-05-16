package com.shTest.equipment.repository;

import com.shTest.entity.EquipmentUsing;
import com.shTest.equipment.dto.EquipmentCateDto;
import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.dto.EquipmentListWithCount;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EquipmentCustomRepository {
    EquipmentListWithCount eqpList(EquipmentDto eqpDto , int tag);
    List<EquipmentCateDto> eqpCateList(String keyWord);
    Integer eqpCateNoFind(String tag);
    EquipmentDto eqpDetail(int eqpNo);
    List<EquipmentUsing> findByEqpNoIs(int eqpNo);
    int eqpCateCount(int eqpCateNo);
}
