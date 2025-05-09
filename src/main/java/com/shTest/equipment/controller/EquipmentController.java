package com.shTest.equipment.controller;

import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eqp")
public class EquipmentController {

    private final EquipmentService eqpService;

    @GetMapping("/eqpList")
    public List<EquipmentDto> eqplist() {
        return eqpService.eqpList(null);
    }

    @GetMapping("/eqpCateList")
    public List<EquipmentDto> eqpCateList(){
        return eqpService.eqpCateList();
    }

    @GetMapping("/keyWord/{keyWord}")
    public List<EquipmentDto> keyWord(@PathVariable("keyWord") String keyWord) {
        return eqpService.eqpList(keyWord);
    }


}
