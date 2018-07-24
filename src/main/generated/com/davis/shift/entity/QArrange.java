package com.davis.shift.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QArrange is a Querydsl query type for Arrange
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArrange extends EntityPathBase<Arrange> {

    private static final long serialVersionUID = -1570645371L;

    public static final QArrange arrange = new QArrange("arrange");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath categoryId = createString("categoryId");

    //inherited
    public final DateTimePath<java.util.Calendar> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdUserId = _super.createdUserId;

    public final NumberPath<Integer> day = createNumber("day", Integer.class);

    //inherited
    public final DateTimePath<java.util.Calendar> deletedAt = _super.deletedAt;

    public final DatePath<java.time.LocalDate> dt = createDate("dt", java.time.LocalDate.class);

    public final NumberPath<Integer> durationMinute = createNumber("durationMinute", Integer.class);

    public final TimePath<java.time.LocalTime> endAt = createTime("endAt", java.time.LocalTime.class);

    //inherited
    public final StringPath id = _super.id;

    public final NumberPath<Integer> month = createNumber("month", Integer.class);

    public final StringPath regionId = createString("regionId");

    public final TimePath<java.time.LocalTime> startAt = createTime("startAt", java.time.LocalTime.class);

    //inherited
    public final NumberPath<Integer> status = _super.status;

    //inherited
    public final DateTimePath<java.util.Calendar> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedUserId = _super.updatedUserId;

    public final StringPath userId = createString("userId");

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QArrange(String variable) {
        super(Arrange.class, forVariable(variable));
    }

    public QArrange(Path<? extends Arrange> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArrange(PathMetadata metadata) {
        super(Arrange.class, metadata);
    }

}

