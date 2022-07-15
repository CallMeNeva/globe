package io.github.callmeneva.globe.language;

import io.github.callmeneva.globe.country.Country;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "countrylanguage")
@IdClass(value = Language.PrimaryKey.class)
@Getter
@Setter
@NoArgsConstructor
public class Language {

    // Primitives are marked as nullable/non-nullable simply to stay consistent with the related table creation DDL query

    @NoArgsConstructor
    @EqualsAndHashCode
    public static class PrimaryKey implements Serializable {

        private String name;
        private Country country;
    }

    @Id
    @Column(name = "language", length = 30, nullable = false)
    private String name;

    @Id
    @ManyToOne
    @JoinColumn(name = "countrycode", referencedColumnName = "code", nullable = false)
    private Country country;

    @Column(name = "isofficial", nullable = false)
    private boolean official;

    @Column(name = "percentage", precision = 4, scale = 1, nullable = false)
    private float percentage;

    // equals and hashCode are implemented in accordance to item #2 of the following post:
    // https://habr.com/ru/company/haulmont/blog/564682/#comment_23200632

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Language other
                && country.equals(other.country)
                && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }

    // Non-generated to provide a simpler impl and avoid performance issues related to foreign key loading (according to JPA Buddy)
    @Override
    public String toString() {
        return name + " (" + country.getName() + ')';
    }
}
