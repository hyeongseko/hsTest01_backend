package com.shTest.equipment.service;

import com.shTest.entity.Equipment;
import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class EquipmentService {

    private final EquipmentRepository eqpRep;

    public List<EquipmentDto> eqpList(String keyWord) {
        return eqpRep.eqpList(keyWord);
    }

    public List<EquipmentDto> eqpCateList(){
        return eqpRep.eqpCateList();
    }
}
