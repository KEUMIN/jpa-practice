package org.keumin.jpa_practice.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("FOOD")
@Getter @Setter
public class Food extends BaseEntity {
    private int calories;
    private LocalDateTime expirationDate;
}
