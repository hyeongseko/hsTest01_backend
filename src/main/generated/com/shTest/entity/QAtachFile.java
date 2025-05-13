package com.shTest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAtachFile is a Querydsl query type for AtachFile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAtachFile extends EntityPathBase<AtachFile> {

    private static final long serialVersionUID = -158878658L;

    public static final QAtachFile atachFile = new QAtachFile("atachFile");

    public final NumberPath<Integer> atchFileId = createNumber("atchFileId", Integer.class);

    public QAtachFile(String variable) {
        super(AtachFile.class, forVariable(variable));
    }

    public QAtachFile(Path<? extends AtachFile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAtachFile(PathMetadata metadata) {
        super(AtachFile.class, metadata);
    }

}

