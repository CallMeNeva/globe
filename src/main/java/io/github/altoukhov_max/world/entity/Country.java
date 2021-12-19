/*
 * Copyright 2021 Maxim Altoukhov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.altoukhov_max.world.entity;

import io.github.altoukhov_max.world.entity.attribute.Continent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Year;

@Entity
@Table(name = "country")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode // FIXME: Most likely a source of bugs (and performance issues, according to IntelliJ IDEA)
public class Country {

    // Primitives are marked as nullable/non-nullable simply to stay consistent with the related table creation DLL query

    @Column(name = "name", length = 52, nullable = false)
    private String name;

    @Column(name = "localname", length = 45, nullable = false)
    private String localName;

    @Id
    @Column(name = "code", length = 3, nullable = false)
    private String alpha3Code;

    @Column(name = "code2", length = 2, nullable = false)
    private String alpha2Code;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capital", referencedColumnName = "id")
    private City capital;

    @Column(name = "continent", nullable = false)
    private Continent continent;

    @Column(name = "region", length = 26, nullable = false)
    private String regionName;

    @Column(name = "surfacearea", precision = 10, scale = 2, nullable = false)
    private BigDecimal surfaceArea;

    @Column(name = "governmentform", length = 45, nullable = false)
    private String governmentFormName;

    @Column(name = "headofstate", length = 60)
    private String headOfStateName;

    @Column(name = "indepyear")
    private Year independenceYear;

    @Column(name = "population", nullable = false)
    private int populationCount;

    // java.time.Period doesn't work with floats[1] even though ISO-8601 officially supports fractions in its notation[2]. Calculating by
    // hand in an AttributeConverter may lead to data inconsistencies between conversions. For these reasons a simple float is used instead
    // (wrapper class is used because column is nullable).
    //
    // References:
    // [1] https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/Period.html#parse(java.lang.CharSequence)
    // [2] https://en.wikipedia.org/wiki/ISO_8601#Durations
    @Column(name = "lifeexpectancy", precision = 3, scale = 1)
    private Float lifeExpectancy;

    @Column(name = "gnp", precision = 10, scale = 2)
    private BigDecimal grossNationalProduct;

    @Column(name = "gnpold", precision = 10, scale = 2)
    private BigDecimal oldGrossNationalProduct;

    // Non-generated to provide a simpler impl and avoid performance issues related to foreign key loading (according to IntelliJ IDEA)
    @Override
    public String toString() {
        return name;
    }
}
