package com.shTest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEquipmentCate is a Querydsl query type for EquipmentCate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEquipmentCate extends EntityPathBase<EquipmentCate> {

    private static final long serialVersionUID = -340095188L;

    public static final QEquipmentCate equipmentCate = new QEquipmentCate("equipmentCate");

    public final NumberPath<Integer> chNo = createNumber("chNo", Integer.class);

    public final StringPath eqpCateDelyn = createString("eqpCateDelyn");

    public final StringPath eqpCateNm = createString("eqpCateNm");

    public final NumberPath<Integer> eqpCateNo = createNumber("eqpCateNo", Integer.class);

    public QEquipmentCate(String variable) {
        super(EquipmentCate.class, forVariable(variable));
    }

    public QEquipmentCate(Path<? extends EquipmentCate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEquipmentCate(PathMetadata metadata) {
        super(EquipmentCate.class, metadata);
    }

}

