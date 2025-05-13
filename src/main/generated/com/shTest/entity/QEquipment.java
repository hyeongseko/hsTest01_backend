package com.shTest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEquipment is a Querydsl query type for Equipment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEquipment extends EntityPathBase<Equipment> {

    private static final long serialVersionUID = 1018299965L;

    public static final QEquipment equipment = new QEquipment("equipment");

    public final NumberPath<Integer> chNo = createNumber("chNo", Integer.class);

    public final NumberPath<Integer> eqpCateNo = createNumber("eqpCateNo", Integer.class);

    public final StringPath eqpContent = createString("eqpContent");

    public final StringPath eqpDelyn = createString("eqpDelyn");

    public final DateTimePath<java.util.Date> eqpDt = createDateTime("eqpDt", java.util.Date.class);

    public final DateTimePath<java.util.Date> eqpDue = createDateTime("eqpDue", java.util.Date.class);

    public final NumberPath<Integer> eqpFildId = createNumber("eqpFildId", Integer.class);

    public final NumberPath<Integer> eqpmngr = createNumber("eqpmngr", Integer.class);

    public final StringPath eqpNm = createString("eqpNm");

    public final NumberPath<Integer> eqpNo = createNumber("eqpNo", Integer.class);

    public final NumberPath<Integer> eqpUsing = createNumber("eqpUsing", Integer.class);

    public final NumberPath<Integer> thNo = createNumber("thNo", Integer.class);

    public QEquipment(String variable) {
        super(Equipment.class, forVariable(variable));
    }

    public QEquipment(Path<? extends Equipment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEquipment(PathMetadata metadata) {
        super(Equipment.class, metadata);
    }

}

