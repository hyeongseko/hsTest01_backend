package com.shTest.equipment.controller;

import com.shTest.equipment.dto.EquipmentCateDto;
import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.dto.EquipmentListWithCount;
import com.shTest.equipment.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eqp")
public class EquipmentController {

    private final EquipmentService eqpService;

    @GetMapping("/eqpList")
    public EquipmentListWithCount eqplist() {
        return eqpService.eqpList(null, null);
    }


    @GetMapping("/eqpKeyWord/{keyWord}")
    public EquipmentListWithCount eqpKeyWord(@PathVariable("keyWord") String keyWord) {
        return eqpService.eqpList(keyWord, null);
    }

    @GetMapping("/eqpTag/{tag}")
    public EquipmentListWithCount eqpTag(@PathVariable("tag") String tag) {
        return eqpService.eqpList(null, tag);
    }

    @GetMapping("/eqpCateList")
    public List<EquipmentCateDto> eqpCateList() {
        return eqpService.eqpCateList(null);
    }

    @GetMapping("/eqpDetail/{eqpNo}")
    public EquipmentDto eqpDetail(@PathVariable("eqpNo") int eqpNo) {
        return eqpService.eqpDetail(eqpNo);
    }

    @PostMapping("/eqpUsingChange/{eqpUsing}")
    public EquipmentDto eqpUsingChange(
            @PathVariable("eqpUsing") String eqpUsing
            , @RequestBody EquipmentDto eqpDto) {
        return eqpService.eqpUsingChange(eqpUsing, eqpDto);
    }

    @PostMapping("/eqpFileInsert")
    public int eqpFileInsert(@RequestParam("file") MultipartFile file) {
        return eqpService.eqpFileInsert(file);
    }

    @PostMapping("/eqpInsert/{atchFileId}")
    public int eqpInsert(@PathVariable("atchFileId") int atchFileId, @RequestBody EquipmentDto eqpDto) {
        return eqpService.eqpInsert(atchFileId, eqpDto);
    }

    @PostMapping("/eqpDelete/{eqpNo}")
    public void eqpDelete(@PathVariable("eqpNo") int eqpNo) {
        eqpService.eqpDelete(eqpNo);
    }

    @PostMapping("/eqpUsingInsert")
    public void eqpUsingInsert(@RequestBody EquipmentDto eqpDto) {
        eqpService.eqpUsingInsert(eqpDto);
    }

    @PostMapping("/eqpCateInsert")
    public void eqpCateInsert(@RequestBody EquipmentCateDto eqpCateDto) {
        eqpService.eqpCateInsert(eqpCateDto);
    }


}
