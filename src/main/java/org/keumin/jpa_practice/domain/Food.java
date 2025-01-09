package org.keumin.jpa_practice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Food {
    @EmbeddedId
    private FoodPrimaryKey pk;

    private int calories;
    private LocalDateTime expirationDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "gift_id")
    private Gift gift;
}
