package com.shTest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QComDetailCd is a Querydsl query type for ComDetailCd
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComDetailCd extends EntityPathBase<ComDetailCd> {

    private static final long serialVersionUID = -435104222L;

    public static final QComDetailCd comDetailCd = new QComDetailCd("comDetailCd");

    public final StringPath comClsfCdId = createString("comClsfCdId");

    public final StringPath comDetailCdId = createString("comDetailCdId");

    public final StringPath ComDetailCdNm = createString("ComDetailCdNm");

    public QComDetailCd(String variable) {
        super(ComDetailCd.class, forVariable(variable));
    }

    public QComDetailCd(Path<? extends ComDetailCd> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComDetailCd(PathMetadata metadata) {
        super(ComDetailCd.class, metadata);
    }

}

