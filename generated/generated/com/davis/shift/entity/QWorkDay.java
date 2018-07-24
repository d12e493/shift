package com.davis.shift.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkDay is a Querydsl query type for WorkDay
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkDay extends EntityPathBase<WorkDay> {

    private static final long serialVersionUID = 688936356L;

    public static final QWorkDay workDay = new QWorkDay("workDay");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Calendar> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdUserId = _super.createdUserId;

    public final NumberPath<Integer> day = createNumber("day", Integer.class);

    //inherited
    public final DateTimePath<java.util.Calendar> deletedAt = _super.deletedAt;

    public final DatePath<java.time.LocalDate> dt = createDate("dt", java.time.LocalDate.class);

    //inherited
    public final StringPath id = _super.id;

    public final NumberPath<Integer> month = createNumber("month", Integer.class);

    public final StringPath name = createString("name");

    //inherited
    public final NumberPath<Integer> status = _super.status;

    //inherited
    public final DateTimePath<java.util.Calendar> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedUserId = _super.updatedUserId;

    public final BooleanPath work = createBoolean("work");

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QWorkDay(String variable) {
        super(WorkDay.class, forVariable(variable));
    }

    public QWorkDay(Path<? extends WorkDay> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkDay(PathMetadata metadata) {
        super(WorkDay.class, metadata);
    }

}

