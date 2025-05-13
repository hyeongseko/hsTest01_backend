package com.shTest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCalendar is a Querydsl query type for Calendar
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCalendar extends EntityPathBase<Calendar> {

    private static final long serialVersionUID = 96897199L;

    public static final QCalendar calendar = new QCalendar("calendar");

    public final BooleanPath allDay = createBoolean("allDay");

    public final StringPath color = createString("color");

    public final DateTimePath<java.util.Date> endDt = createDateTime("endDt", java.util.Date.class);

    public final StringPath schdlCd = createString("schdlCd");

    public final StringPath schdlConts = createString("schdlConts");

    public final NumberPath<Long> schdlNo = createNumber("schdlNo", Long.class);

    public final StringPath schdlTtl = createString("schdlTtl");

    public final DateTimePath<java.util.Date> strtDt = createDateTime("strtDt", java.util.Date.class);

    public QCalendar(String variable) {
        super(Calendar.class, forVariable(variable));
    }

    public QCalendar(Path<? extends Calendar> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCalendar(PathMetadata metadata) {
        super(Calendar.class, metadata);
    }

}

