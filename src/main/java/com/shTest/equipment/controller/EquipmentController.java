package com.shTest.equipment.controller;

import com.shTest.entity.Equipment;
import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eqp")
public class EquipmentController {

    private final EquipmentService eqpService;

    @GetMapping("/list")
    public List<EquipmentDto> eqpList() {
       return eqpService.eqpList();
    }

}
