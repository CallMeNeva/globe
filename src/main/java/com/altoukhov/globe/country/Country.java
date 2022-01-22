package com.altoukhov.globe.country;

import com.altoukhov.globe.city.City;
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
import java.util.Objects;

@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
public class Country {

    // Primitives are marked as nullable/non-nullable simply to stay consistent with the related table creation DDL query

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

    // equals and hashCode are implemented in accordance to item #2 of the following post:
    // https://habr.com/ru/company/haulmont/blog/564682/#comment_23200632

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Country other && alpha3Code.equals(other.alpha3Code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alpha3Code);
    }

    // Non-generated to provide a simpler impl and avoid performance issues related to foreign key loading (according to JPA Buddy)
    @Override
    public String toString() {
        return name;
    }
}
