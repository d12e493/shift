package com.davis.shift.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrganize is a Querydsl query type for Organize
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrganize extends EntityPathBase<Organize> {

    private static final long serialVersionUID = 1164223978L;

    public static final QOrganize organize = new QOrganize("organize");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Calendar> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdUserId = _super.createdUserId;

    //inherited
    public final DateTimePath<java.util.Calendar> deletedAt = _super.deletedAt;

    //inherited
    public final StringPath id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath organizeId = createString("organizeId");

    //inherited
    public final NumberPath<Integer> status = _super.status;

    //inherited
    public final DateTimePath<java.util.Calendar> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedUserId = _super.updatedUserId;

    public QOrganize(String variable) {
        super(Organize.class, forVariable(variable));
    }

    public QOrganize(Path<? extends Organize> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrganize(PathMetadata metadata) {
        super(Organize.class, metadata);
    }

}

