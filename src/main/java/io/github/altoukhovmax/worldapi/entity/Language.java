package io.github.altoukhovmax.worldapi.entity;

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
public class Language {

    public static class PrimaryKey implements Serializable {

        private String name;
        private Country country;

        public PrimaryKey() {
        }

        @Override
        public boolean equals(Object obj) {
            return (this == obj) || obj instanceof PrimaryKey otherKey
                    && Objects.equals(name, otherKey.name)
                    && Objects.equals(country, otherKey.country);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, country);
        }
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

    public Language() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object anObject) {
        return (this == anObject) || (anObject instanceof Language otherLanguage
                && Objects.equals(name, otherLanguage.name)
                && Objects.equals(country, otherLanguage.country)
                && Objects.equals(official, otherLanguage.official)
                && Objects.equals(percentage, otherLanguage.percentage));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, official, percentage);
    }

    @Override
    public String toString() {
        return name + " [" + country.getName() + ']';
    }
}
