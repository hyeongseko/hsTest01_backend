package com.shTest.equipment.repository;

import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.dto.EquipmentListWithCount;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EquipmentCustomRepository {
    EquipmentListWithCount eqpList(String keyWord , int tag, Pageable pageable);
    List<EquipmentDto> eqpCateList(String keyWord);
    Integer eqpCateNoFind(String tag);
    EquipmentDto eqpDetail(int eqpNo);
}
