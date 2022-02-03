// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package io.github.callmeneva.globe.city;

import io.github.callmeneva.globe.country.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
public class City {

    // Primitives are marked as nullable/non-nullable simply to stay consistent with the related table creation DDL query

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 35, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countrycode", referencedColumnName = "code", nullable = false)
    private Country country;

    @Column(name = "district", length = 20, nullable = false)
    private String districtName;

    @Column(name = "population", nullable = false)
    private int populationCount;

    // equals and hashCode are implemented in accordance to item #3 of the following post:
    // https://habr.com/ru/company/haulmont/blog/564682/#comment_23200632

    @Override
    public boolean equals(Object obj) {
        return obj instanceof City other && id == other.id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    // Non-generated to provide a simpler impl and avoid performance issues related to foreign key loading (according to JPA Buddy)
    @Override
    public String toString() {
        return name;
    }
}
