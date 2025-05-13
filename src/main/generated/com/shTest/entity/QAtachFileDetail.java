package com.shTest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAtachFileDetail is a Querydsl query type for AtachFileDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAtachFileDetail extends EntityPathBase<AtachFileDetail> {

    private static final long serialVersionUID = -528346577L;

    public static final QAtachFileDetail atachFileDetail = new QAtachFileDetail("atachFileDetail");

    public final NumberPath<Integer> atchDetailFileId = createNumber("atchDetailFileId", Integer.class);

    public final StringPath atchFileExtn = createString("atchFileExtn");

    public final NumberPath<Integer> atchFileId = createNumber("atchFileId", Integer.class);

    public final StringPath atchFileOrginNm = createString("atchFileOrginNm");

    public final StringPath atchFilePath = createString("atchFilePath");

    public QAtachFileDetail(String variable) {
        super(AtachFileDetail.class, forVariable(variable));
    }

    public QAtachFileDetail(Path<? extends AtachFileDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAtachFileDetail(PathMetadata metadata) {
        super(AtachFileDetail.class, metadata);
    }

}

