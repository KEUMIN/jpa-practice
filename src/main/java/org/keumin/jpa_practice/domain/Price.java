package org.keumin.jpa_practice.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Price {
    private Integer originalPrice;
    private Integer discountPrice;
}
