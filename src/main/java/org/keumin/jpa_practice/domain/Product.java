package org.keumin.jpa_practice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "prod_type", discriminatorType = DiscriminatorType.STRING)
@Getter @Setter
public class Product extends BaseEntity {
    @Embedded
    private Price price;
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
