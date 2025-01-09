package org.keumin.jpa_practice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Customer extends BaseEntity{
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Food> foods;
}
