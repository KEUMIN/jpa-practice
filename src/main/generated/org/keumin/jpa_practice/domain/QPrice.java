package org.keumin.jpa_practice.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPrice is a Querydsl query type for Price
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPrice extends BeanPath<Price> {

    private static final long serialVersionUID = 183596193L;

    public static final QPrice price = new QPrice("price");

    public final NumberPath<Integer> discountPrice = createNumber("discountPrice", Integer.class);

    public final NumberPath<Integer> originalPrice = createNumber("originalPrice", Integer.class);

    public QPrice(String variable) {
        super(Price.class, forVariable(variable));
    }

    public QPrice(Path<? extends Price> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrice(PathMetadata metadata) {
        super(Price.class, metadata);
    }

}

