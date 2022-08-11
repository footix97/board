package com.bbs.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBbsEntity is a Querydsl query type for BbsEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBbsEntity extends EntityPathBase<BbsEntity> {

    private static final long serialVersionUID = 950119483L;

    public static final QBbsEntity bbsEntity = new QBbsEntity("bbsEntity");

    public final StringPath detl = createString("detl");

    public final StringPath filename = createString("filename");

    public final StringPath fileuuid = createString("fileuuid");

    public final NumberPath<Integer> seq = createNumber("seq", Integer.class);

    public final StringPath title = createString("title");

    public final StringPath user = createString("user");

    public QBbsEntity(String variable) {
        super(BbsEntity.class, forVariable(variable));
    }

    public QBbsEntity(Path<? extends BbsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBbsEntity(PathMetadata metadata) {
        super(BbsEntity.class, metadata);
    }

}

