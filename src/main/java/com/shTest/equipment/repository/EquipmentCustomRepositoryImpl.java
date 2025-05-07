package com.shTest.equipment.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shTest.equipment.dto.EquipmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.shTest.entity.QEquipment.equipment;

@RequiredArgsConstructor
@Repository
public class EquipmentCustomRepositoryImpl implements EquipmentCustomRepository {

    private final JPAQueryFactory queryFactory;

    public List<EquipmentDto> eqpList(){
        return queryFactory.select(Projections.fields(EquipmentDto.class, equipment.eqpNo, equipment)).from(equipment).fetch();
    }
}



