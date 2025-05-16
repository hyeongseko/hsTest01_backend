package com.shTest.equipment.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shTest.entity.EquipmentUsing;
import com.shTest.equipment.dto.AtchFileDto;
import com.shTest.equipment.dto.EquipmentCateDto;
import com.shTest.equipment.dto.EquipmentDto;
import com.shTest.equipment.dto.EquipmentListWithCount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.shTest.entity.QAtachFileDetail.atachFileDetail;
import static com.shTest.entity.QChannelThread.channelThread;
import static com.shTest.entity.QEquipment.equipment;
import static com.shTest.entity.QEquipmentCate.equipmentCate;
import static com.shTest.entity.QEquipmentUsing.equipmentUsing;
import static com.shTest.entity.QMember.member;

@RequiredArgsConstructor
@Repository
public class EquipmentCustomRepositoryImpl implements EquipmentCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public EquipmentListWithCount eqpList(EquipmentDto eqpDto, int tag) {
        // 채널 공용자원 -> 자원번호로 정렬
        NumberExpression<Integer> rankPath = new CaseBuilder()
                .when(equipment.thNo.eq(0))
                .then(0)
                .otherwise(1);

        List<EquipmentDto> eqpList =
                queryFactory
                        .select(Projections.fields(EquipmentDto.class
                                , equipment.eqpNo
                                , equipment.eqpNm
                                , equipment.eqpUsing
                                , equipment.eqpDt
                                , equipment.eqpDue
                                , equipmentCate.eqpCateNm
                                , member.chMemNm
                                , channelThread.thTtl)
                        )
                        .from(equipment)
                        .leftJoin(equipmentCate).on(equipment.eqpCateNo.eq(equipmentCate.eqpCateNo))
                        .leftJoin(channelThread).on(equipment.thNo.eq(channelThread.thNo))
                        .leftJoin(member).on(equipment.eqpmngr.eq(member.chMemNo))
                        .where(
                                equipment.eqpDelyn.eq("N")
                                , equipment.chNo.eq(95)
                                , containEqpName(eqpDto)
                                , containEqpTagName(tag))
                        .orderBy(rankPath.asc(),
                                equipment.eqpNo.asc())
                        .fetch();

        int totalCount =
                queryFactory
                        .select(equipment.count().intValue())
                        .from(equipment)
                        .leftJoin(channelThread).on(equipment.thNo.eq(channelThread.thNo))
                        .leftJoin(member).on(equipment.eqpmngr.eq(member.chMemNo))
                        .where(
                                equipment.eqpDelyn.eq("N")
                                , equipment.chNo.eq(95)
                                , containEqpName(eqpDto)
                                , containEqpTagName(tag))
                        .fetchOne();
        return new EquipmentListWithCount(eqpList, totalCount);
    }

    public List<EquipmentCateDto> eqpCateList(String keyWord) {
        return queryFactory
                .select(Projections.fields(EquipmentCateDto.class
                        , equipmentCate.eqpCateNm
                        , equipmentCate.eqpCateNo))
                .from(equipmentCate)
                .where(
                        equipmentCate.chNo.eq(95)
                        , equipmentCate.eqpCateDelyn.eq("N")
                        , containEqpCateName(keyWord))
                .fetch();
    }

    public Integer eqpCateNoFind(String tag) {
        return queryFactory
                .select(equipmentCate.eqpCateNo)
                .from(equipmentCate)
                .where(
                        equipmentCate.chNo.eq(95)
                        , equipmentCate.eqpCateDelyn.eq("N")
                        , equipmentCate.eqpCateNm.eq(tag))
                .fetchOne();
    }    // 카테고리 수를 확인하여 없을때만 카테고리 삭제

    public int eqpCateCount(int eqpCateNo) {
        return queryFactory
                .select(equipment.count().intValue())
                .from(equipment)
                .where(
                        equipment.eqpCateNo.eq(eqpCateNo)
                )
                .fetchOne();
    }


    public EquipmentDto eqpDetail(int eqpNo) {
        EquipmentDto eqpDto = queryFactory
                .select(Projections.fields(EquipmentDto.class
                        , equipment.eqpNo
                        , equipment.eqpNm
                        , equipment.eqpmngr
                        , equipment.eqpDt
                        , equipment.eqpDue
                        , equipment.eqpContent
                        , equipment.eqpUsing
                        , equipment.eqpCateNo
                        , equipmentCate.eqpCateNm
                        , member.chMemNm))
                .from(equipment)
                .leftJoin(equipmentCate).on(equipment.eqpCateNo.eq(equipmentCate.eqpCateNo))
                .leftJoin(channelThread).on(equipment.thNo.eq(channelThread.thNo))
                .leftJoin(member).on(equipment.eqpmngr.eq(member.chMemNo))
                .where(equipment.eqpNo.eq(eqpNo))
                .fetchOne();

        AtchFileDto atchFileDto = queryFactory
                .select(Projections.fields(AtchFileDto.class
                        , atachFileDetail.atchFileId
                        , atachFileDetail.atachFileDetail
                        , atachFileDetail.atchFilePath
                        , atachFileDetail.atchFileExtn
                        , atachFileDetail.atchFileOrginNm))
                .from(atachFileDetail)
                .leftJoin(equipment).on(atachFileDetail.atchFileId.eq(equipment.eqpFildId))
                .where(equipment.eqpNo.eq(eqpNo))
                .fetchOne();

        eqpDto.setAtchFileDto(atchFileDto);
        return eqpDto;
    }

    public List<EquipmentUsing> findByEqpNoIs(int eqpNo) {
        return queryFactory
                .selectFrom(equipmentUsing)
                .where(equipmentUsing.eqpNo.eq(eqpNo))
                .fetch();
    }

    // 검색 키워드로 자원 이름 검색
    private BooleanExpression containEqpName(EquipmentDto eqpDto) {
        if (eqpDto == null)
            return null;
        if (eqpDto.getKeyWordGubun().equals("eqpNm")) return equipment.eqpNm.containsIgnoreCase(eqpDto.getKeyWord());
        else if (eqpDto.getKeyWordGubun().equals("chMemNm"))
            return member.chMemNm.containsIgnoreCase(eqpDto.getKeyWord());
        else return channelThread.thTtl.containsIgnoreCase(eqpDto.getKeyWord());
    }


    // #태그로 카테고리별 자원 리스트 검색
    private BooleanExpression containEqpTagName(int tag) {
        if (tag == 0)
            return null;
        return equipment.eqpCateNo.eq(tag);
    }

    // #태그로 카테고리 번호 검색
    private BooleanExpression containEqpCateName(String keyWord) {
        if (keyWord == null || keyWord.isEmpty() || keyWord.equals("null")) {
            return null;
        }
        return equipmentCate.eqpCateNm.contains(keyWord);
    }
}






