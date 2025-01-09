package org.keumin.jpa_practice.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGift is a Querydsl query type for Gift
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGift extends EntityPathBase<Gift> {

    private static final long serialVersionUID = 1529666264L;

    public static final QGift gift = new QGift("gift");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath code = _super.code;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QGift(String variable) {
        super(Gift.class, forVariable(variable));
    }

    public QGift(Path<? extends Gift> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGift(PathMetadata metadata) {
        super(Gift.class, metadata);
    }

}

