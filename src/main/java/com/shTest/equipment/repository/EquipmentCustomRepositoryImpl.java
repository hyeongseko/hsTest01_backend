package com.shTest.equipment.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shTest.entity.Equipment;
import com.shTest.equipment.dto.EquipmentDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.shTest.entity.QEquipment.equipment;
import static com.shTest.entity.QEquipmentSort.equipmentSort;
import static com.shTest.entity.QMember.member;
import static com.shTest.entity.QChannelThread.channelThread;

@RequiredArgsConstructor
@Repository
public class EquipmentCustomRepositoryImpl implements EquipmentCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<EquipmentDto> eqpList(String keyWord) {
        NumberExpression<Integer> rankPath = new CaseBuilder()
                .when(equipment.thNo.eq(0))
                .then(0)
                .otherwise(1);
        return queryFactory
                .select(Projections.fields(EquipmentDto.class
                        , equipment.eqpNo
                        , equipment.eqpNm
                        , equipment.eqpUsing
                        , equipment.eqpDt
                        , equipmentSort.eqpCateNm
                        , member.chMemNm
                        , channelThread.thTtl)
                )
                .from(equipment)
                .leftJoin(equipmentSort).on(equipment.eqpCateNo.eq(equipmentSort.eqpCateNo))
                .leftJoin(channelThread).on(equipment.thNo.eq(channelThread.thNo))
                .leftJoin(member).on(equipment.eqpmngr.eq(member.chMemNo))
                .where(equipment.eqpDelyn.eq("N"), containName(keyWord), equipment.chNo.eq(95))
                .orderBy(rankPath.asc(),
                        equipment.eqpNo.asc())
                .fetch();
    }

    public List<EquipmentDto> eqpCateList() {
        return queryFactory
                .select(Projections.fields(EquipmentDto.class
                        , equipmentSort.eqpCateNm))
                .from(equipmentSort)
                .leftJoin(equipment).on(equipmentSort.eqpCateNo.eq(equipment.eqpCateNo))
                .where(equipmentSort.chNo.eq(95), equipment.eqpDelyn.eq("N"))
                .fetch();
    }

    private BooleanExpression containName(String keyWord) {
        if (keyWord == null || keyWord.isEmpty() || keyWord.equals("null")) {
            return null;
        }
        return equipment.eqpNm.contains(keyWord);
    }

}






