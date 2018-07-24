package com.davis.shift.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItem is a Querydsl query type for Item
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItem extends EntityPathBase<Item> {

    private static final long serialVersionUID = 2045958874L;

    public static final QItem item = new QItem("item");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Calendar> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdUserId = _super.createdUserId;

    //inherited
    public final DateTimePath<java.util.Calendar> deletedAt = _super.deletedAt;

    public final StringPath description = createString("description");

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

    public QItem(String variable) {
        super(Item.class, forVariable(variable));
    }

    public QItem(Path<? extends Item> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItem(PathMetadata metadata) {
        super(Item.class, metadata);
    }

}

