package io.github.altoukhov_max.world.entity;

import io.github.altoukhov_max.world.entity.attribute.Continent;

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
public class Country {

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
    // hand in an AttributeConverter may lead to data inconsistencies between conversions. For these reasons a simple float is used instead.
    // Wrapper class is used because column allows nulls.
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

    public Country() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public BigDecimal getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(BigDecimal surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public String getGovernmentFormName() {
        return governmentFormName;
    }

    public void setGovernmentFormName(String governmentFormName) {
        this.governmentFormName = governmentFormName;
    }

    public String getHeadOfStateName() {
        return headOfStateName;
    }

    public void setHeadOfStateName(String headOfStateName) {
        this.headOfStateName = headOfStateName;
    }

    public Year getIndependenceYear() {
        return independenceYear;
    }

    public void setIndependenceYear(Year independenceYear) {
        this.independenceYear = independenceYear;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(int populationCount) {
        this.populationCount = populationCount;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public BigDecimal getGrossNationalProduct() {
        return grossNationalProduct;
    }

    public void setGrossNationalProduct(BigDecimal grossNationalProduct) {
        this.grossNationalProduct = grossNationalProduct;
    }

    public BigDecimal getOldGrossNationalProduct() {
        return oldGrossNationalProduct;
    }

    public void setOldGrossNationalProduct(BigDecimal oldGrossNationalProduct) {
        this.oldGrossNationalProduct = oldGrossNationalProduct;
    }

    @Override
    public String toString() {
        return name;
    }
}
