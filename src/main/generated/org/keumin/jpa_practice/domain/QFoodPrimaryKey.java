package org.keumin.jpa_practice.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFoodPrimaryKey is a Querydsl query type for FoodPrimaryKey
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QFoodPrimaryKey extends BeanPath<FoodPrimaryKey> {

    private static final long serialVersionUID = -1940436061L;

    public static final QFoodPrimaryKey foodPrimaryKey = new QFoodPrimaryKey("foodPrimaryKey");

    public final StringPath company = createString("company");

    public final StringPath name = createString("name");

    public QFoodPrimaryKey(String variable) {
        super(FoodPrimaryKey.class, forVariable(variable));
    }

    public QFoodPrimaryKey(Path<? extends FoodPrimaryKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodPrimaryKey(PathMetadata metadata) {
        super(FoodPrimaryKey.class, metadata);
    }

}

