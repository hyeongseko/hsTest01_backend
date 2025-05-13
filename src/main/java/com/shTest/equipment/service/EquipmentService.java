package com.shTest.equipment.service;

import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class EquipmentService {

    private final EquipmentRepository eqpRep;

    public Page<EquipmentDto> eqpList(String keyWord, String tag) {
        // 페이징 처리
        PageRequest pageRequest = PageRequest.of(2, 4);

        // 태그로 검색할때
        if (tag != null && !tag.equals("전체 출력"))
            return  eqpRep.eqpList("", eqpRep.eqpCateNoFind(tag), pageRequest);
        // 전체 검색또는 자원을 검색할 때
        return  eqpRep.eqpList(keyWord, 0, pageRequest);
    }

    public List<EquipmentDto> eqpCateList(String keyWord) {
        return eqpRep.eqpCateList(keyWord);
    }

    public EquipmentDto eqpDetail(int eqpNo) {
        return eqpRep.eqpDetail(eqpNo);
    }
}
