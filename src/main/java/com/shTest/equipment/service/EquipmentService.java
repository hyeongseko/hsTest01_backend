package com.shTest.equipment.service;

import com.shTest.entity.*;
import com.shTest.equipment.dto.*;
import com.shTest.equipment.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Service
@Slf4j
public class EquipmentService {

    private final EquipmentRepository eqpRep;
    private final AtachFileRepository afRep;
    private final AtachFileDetailRepository afdRep;
    private final EquipmentUsingRepository eqpUseRep;
    private final EquipmentCateRepository eqpCateRep;

    public EquipmentListWithCount eqpList(EquipmentDto eqpDto, String tag) {

        // 태그로 검색할때
        if (tag != null && !tag.equals("전체 출력")) return eqpRep.eqpList(null, eqpRep.eqpCateNoFind(tag));
        // 전체 검색또는 자원을 검색할 때
        return eqpRep.eqpList(eqpDto, 0);
    }

    public List<EquipmentCateDto> eqpCateList(String keyWord) {
        return eqpRep.eqpCateList(keyWord);
    }

    public EquipmentDto eqpDetail(int eqpNo) {
        return eqpRep.eqpDetail(eqpNo);
    }

    // 파일 생성및 저장
    public int eqpFileInsert(MultipartFile file) {
        if (file != null) {
            // 파일 생성
            String uuid = UUID.randomUUID().toString();
            String createdFileName = uuid + "_" + file.getOriginalFilename();
            String filepath = "C:/upload/temp/equipment/" + createdFileName;
            File fileInput = new File(filepath);
            try {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileInput));
                bos.write(file.getBytes());
                bos.close();
            } catch (Exception e) {
                return 0;
            }

            AtchFileDto atchFileDto = new AtchFileDto();
            //file
            AtachFile af = new AtachFile(atchFileDto);
            afRep.save(af);

            // detail
            atchFileDto.setAtchFileId(af.getAtchFileId());
            atchFileDto.setAtchFilePath("/" + createdFileName);
            atchFileDto.setAtchFileExtn(createdFileName.substring(createdFileName.lastIndexOf(".") + 1));
            atchFileDto.setAtchFileSize(file.getSize());
            atchFileDto.setAtchFileOrginNm(file.getOriginalFilename());
            AtachFileDetail afd = new AtachFileDetail(atchFileDto);
            afdRep.save(afd);
            return af.getAtchFileId();
        } else return 0;
    }

    public int eqpInsert(int atchFileId, EquipmentDto eqpDto) {
        Equipment eqpEnt;
        if (atchFileId != 0) {
            eqpDto.getAtchFileDto().setAtchFileId(atchFileId);
        }
        if (eqpDto.getEqpNo() != 0) {
            eqpEnt = eqpRep.findById(eqpDto.getEqpNo()).orElse(null);
            eqpEnt.eqpUpdate(eqpDto.getEqpNm(), eqpDto.getEqpCateNo(), eqpDto.getEqpDue(), eqpDto.getEqpContent(), eqpDto.getAtchFileDto().getAtchFileId());
            eqpRep.save(eqpEnt);
        } else {
            eqpDto.setEqpUsing("사용 가능");
            eqpDto.setEqpmngr(71);
            eqpDto.setChNo(95);
            eqpDto.setEqpDue(new Date());
            eqpEnt = new Equipment(eqpDto);
            eqpRep.save(eqpEnt);
        }
        return eqpEnt.getEqpNo();
    }

    public void eqpUsingInsert(EquipmentUsingDto eqpUsingDto) {
        EquipmentUsing eqpUseEnt = new EquipmentUsing(eqpUsingDto);
        eqpUseRep.save(eqpUseEnt);

        Equipment eqpEnt = eqpRep.findById(eqpUsingDto.getEqpNo()).orElse(null);
        eqpEnt.eqpUsingInsert();
        eqpRep.save(eqpEnt);
    }

    public EquipmentDto eqpUsingChange(String eqpUsing, EquipmentDto eqpDto) {
        eqpDto.setEqpUsing(eqpUsing);
        Equipment eqpEnt = eqpRep.findById(eqpDto.getEqpNo()).orElse(null);
        eqpEnt.eqpUsingUpdate(eqpDto.getEqpUsing());
        eqpRep.save(eqpEnt);

        // 모든 자원들 반납
        List<EquipmentUsing> eqpUseList = eqpRep.findByEqpNoIs(eqpDto.getEqpNo());
        for (EquipmentUsing eqpUseEnt : eqpUseList) {
            eqpUseEnt.EquipmentUsingBroken();
            eqpUseRep.save(eqpUseEnt);
        }
        return eqpRep.eqpDetail(eqpDto.getEqpNo());
    }

    public void eqpDelete(int eqpNo) {
        Equipment eqpEnt = eqpRep.findById(eqpNo).orElse(null);
        eqpEnt.eqpDelete();
        eqpRep.save(eqpEnt);
    }


    public int eqpCateInsert(EquipmentCateDto eqpCateDto) {
        EquipmentCate eqpCateEnt;
        if (eqpCateDto.getEqpCateInsertType().equals("삭제")) {
            if (eqpRep.eqpCateCount(eqpCateDto.getEqpCateNo()) != 0) return 1;
            else {
                eqpCateEnt = eqpCateRep.findById(eqpCateDto.getEqpCateNo()).orElse(null);
                eqpCateEnt.EquipmentCateDelete();
            }
        }
        else eqpCateEnt = new EquipmentCate(eqpCateDto);
        eqpCateRep.save(eqpCateEnt);
        return 0;
    }
}
