package com.shTest.equipment.service;

import com.shTest.entity.*;
import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.dto.EquipmentListWithCount;
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
import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Service
@Slf4j
public class EquipmentService {
    @Value("\\upload\\temp\\") // application 의 properties 의 변수
    private String uploadPath;

    private final EquipmentRepository eqpRep;
    private final AtachFileRepository afRep;
    private final AtachFileDetailRepository afdRep;
    private final EquipmentUsingRepository eqpUseRep;
    private final EquipmentCateRepository eqpCateRep;

    public EquipmentListWithCount eqpList(String keyWord, String tag) {
        // 페이징 처리
        PageRequest pageRequest = PageRequest.of(2, 4);

        // 태그로 검색할때
        if (tag != null && !tag.equals("전체 출력"))
            return eqpRep.eqpList("", eqpRep.eqpCateNoFind(tag), pageRequest);
        // 전체 검색또는 자원을 검색할 때
        return eqpRep.eqpList(keyWord, 0, pageRequest);
    }

    public List<EquipmentDto> eqpCateList(String keyWord) {
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

            EquipmentDto eqpDto = new EquipmentDto();
            //file
            AtachFile af = new AtachFile(eqpDto);
            afRep.save(af);

            // detail
            eqpDto.getAtchFileDto().setAtchFileId(af.getAtchFileId());
            eqpDto.getAtchFileDto().setAtchFilePath("/" + createdFileName);
            eqpDto.getAtchFileDto().setAtchFileExtn(createdFileName.substring(createdFileName.lastIndexOf(".") + 1));
            eqpDto.getAtchFileDto().setAtchFileSize(file.getSize());
            eqpDto.getAtchFileDto().setAtchFileOrginNm(file.getOriginalFilename());
            AtachFileDetail afd = new AtachFileDetail(eqpDto);
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
            eqpEnt = new Equipment(eqpDto);
            eqpRep.save(eqpEnt);
        }
        return eqpEnt.getEqpNo();
    }

    public EquipmentDto eqpUsingChange(String eqpUsing, EquipmentDto eqpDto) {
        eqpDto.setEqpUsing(eqpUsing);
        Equipment eqpEnt = eqpRep.findById(eqpDto.getEqpNo()).orElse(null);
        eqpEnt.eqpUsingUpdate(eqpDto.getEqpUsing());
        eqpRep.save(eqpEnt);

        List<EquipmentUsing> eqpUseList = eqpUseRep.findByEqpNoIs(eqpDto.getEqpNo());
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

    public void eqpUsingInsert(EquipmentDto eqpDto) {
        EquipmentUsing eqpUseEnt = new EquipmentUsing(eqpDto);
        eqpUseRep.save(eqpUseEnt);

        Equipment eqpEnt = eqpRep.findById(eqpDto.getEqpNo()).orElse(null);
        eqpEnt.eqpUsingInsert();
        eqpRep.save(eqpEnt);
    }

    public void eqpCateInsert(EquipmentDto eqpDto) {
        if (eqpDto.getEqpCateInsertType().equals("등록")) {
            EquipmentCate eqpCateEnt = new EquipmentCate(eqpDto);
            eqpCateRep.save(eqpCateEnt);
        } else {
            EquipmentCate eqpCateEnt = eqpCateRep.findById(eqpDto.getEqpCateNo()).orElse(null);
            if (eqpDto.getEqpCateInsertType().equals("변경")) eqpCateEnt.EquipmentCateUpdate(eqpDto.getEqpCateNm());
            else eqpCateEnt.EquipmentCateDelete();
            eqpCateRep.save(eqpCateEnt);
        }
    }
}
