package io.github.altoukhovmax.sampleworldapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Year;
import java.util.Objects;

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

    @OneToOne
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

    // java.time.Period doesn't work with floats[1] even though ISO-8601 officially supports fractions in its
    // notation[2]. Calculating by hand in an AttributeConverter may lead to data inconsistencies between conversions.
    // For these reasons a simple float is used instead. Wrapper class is used because column allows nulls.
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

    public Country() {
    }

    public Country(String name,
                   String localName,
                   String alpha3Code,
                   String alpha2Code,
                   City capital,
                   Continent continent,
                   String regionName,
                   BigDecimal surfaceArea,
                   String governmentFormName,
                   String headOfStateName,
                   Year independenceYear,
                   int populationCount,
                   Float lifeExpectancy,
                   BigDecimal grossNationalProduct,
                   BigDecimal oldGrossNationalProduct) {
        this.name = name;
        this.localName = localName;
        this.alpha3Code = alpha3Code;
        this.alpha2Code = alpha2Code;
        this.capital = capital;
        this.continent = continent;
        this.regionName = regionName;
        this.surfaceArea = surfaceArea;
        this.governmentFormName = governmentFormName;
        this.headOfStateName = headOfStateName;
        this.independenceYear = independenceYear;
        this.populationCount = populationCount;
        this.lifeExpectancy = lifeExpectancy;
        this.grossNationalProduct = grossNationalProduct;
        this.oldGrossNationalProduct = oldGrossNationalProduct;
    }

    public String getName() {
        return name;
    }

    public String getLocalName() {
        return localName;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public City getCapital() {
        return capital;
    }

    public Continent getContinent() {
        return continent;
    }

    public String getRegionName() {
        return regionName;
    }

    public BigDecimal getSurfaceArea() {
        return surfaceArea;
    }

    public String getGovernmentFormName() {
        return governmentFormName;
    }

    public String getHeadOfStateName() {
        return headOfStateName;
    }

    public Year getIndependenceYear() {
        return independenceYear;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public BigDecimal getGrossNationalProduct() {
        return grossNationalProduct;
    }

    public BigDecimal getOldGrossNationalProduct() {
        return oldGrossNationalProduct;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Country otherCountry
                && Objects.equals(name, otherCountry.name)
                && Objects.equals(localName, otherCountry.localName)
                && Objects.equals(alpha3Code, otherCountry.alpha3Code)
                && Objects.equals(alpha2Code, otherCountry.alpha2Code)
                && Objects.equals(capital, otherCountry.capital)
                && Objects.equals(continent, otherCountry.continent)
                && Objects.equals(regionName, otherCountry.regionName)
                && Objects.equals(surfaceArea, otherCountry.surfaceArea)
                && Objects.equals(governmentFormName, otherCountry.governmentFormName)
                && Objects.equals(headOfStateName, otherCountry.headOfStateName)
                && Objects.equals(independenceYear, otherCountry.independenceYear)
                && Objects.equals(populationCount, otherCountry.populationCount)
                && Objects.equals(lifeExpectancy, otherCountry.lifeExpectancy)
                && Objects.equals(grossNationalProduct, otherCountry.grossNationalProduct)
                && Objects.equals(oldGrossNationalProduct, otherCountry.oldGrossNationalProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,
                            localName,
                            alpha3Code,
                            alpha2Code,
                            capital,
                            continent,
                            regionName,
                            surfaceArea,
                            governmentFormName,
                            headOfStateName,
                            independenceYear,
                            populationCount,
                            lifeExpectancy,
                            grossNationalProduct,
                            oldGrossNationalProduct);
    }

    @Override
    public String toString() {
        return name;
    }
}
