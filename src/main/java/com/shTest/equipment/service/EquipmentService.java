package com.shTest.equipment.service;

import com.shTest.entity.Equipment;
import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class EquipmentService {

    private final EquipmentRepository eqpRep;

    public List<EquipmentDto> eqpList() {
        System.out.println("eqplist=========");
        List<EquipmentDto> eqpEntList = eqpRep.eqpList();
        System.out.println("===================: " + eqpEntList);
        return eqpEntList;
    }
}
