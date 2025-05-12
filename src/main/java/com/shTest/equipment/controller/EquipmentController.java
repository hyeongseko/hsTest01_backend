package com.shTest.equipment.controller;

import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eqp")
public class EquipmentController {

    private final EquipmentService eqpService;

    @GetMapping("/eqpList")
    public Page<EquipmentDto> eqplist() {
        return eqpService.eqpList(null, null);
    }

    @GetMapping("/eqpCateList")
    public List<EquipmentDto> eqpCateList() {
        return eqpService.eqpCateList(null);
    }

    @GetMapping("/eqpKeyWord/{keyWord}")
    public Page<EquipmentDto> eqpKeyWord(@PathVariable("keyWord") String keyWord) {
        return eqpService.eqpList(keyWord, null);
    }

    @GetMapping("/eqpTag/{tag}")
    public Page<EquipmentDto> eqpTag(@PathVariable("tag") String tag) {
        return eqpService.eqpList(null, tag);
    }


}
