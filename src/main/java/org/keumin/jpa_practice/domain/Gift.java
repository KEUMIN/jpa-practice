package org.keumin.jpa_practice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Gift extends BaseEntity {
    private int price;
}
