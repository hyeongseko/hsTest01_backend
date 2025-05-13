package com.shTest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QChannelThread is a Querydsl query type for ChannelThread
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChannelThread extends EntityPathBase<ChannelThread> {

    private static final long serialVersionUID = -892429796L;

    public static final QChannelThread channelThread = new QChannelThread("channelThread");

    public final NumberPath<Integer> thNo = createNumber("thNo", Integer.class);

    public final StringPath thTtl = createString("thTtl");

    public QChannelThread(String variable) {
        super(ChannelThread.class, forVariable(variable));
    }

    public QChannelThread(Path<? extends ChannelThread> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChannelThread(PathMetadata metadata) {
        super(ChannelThread.class, metadata);
    }

}

