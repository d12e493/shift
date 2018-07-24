package com.davis.shift.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = 2046222397L;

    public static final QRole role = new QRole("role");

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

    //inherited
    public final NumberPath<Integer> status = _super.status;

    //inherited
    public final DateTimePath<java.util.Calendar> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedUserId = _super.updatedUserId;

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata metadata) {
        super(Role.class, metadata);
    }

}

