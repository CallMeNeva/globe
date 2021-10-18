package io.github.altoukhovmax.sampleworldapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int identifier;

    @Column(name = "name", length = 35, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "countrycode", referencedColumnName = "code", nullable = false)
    private Country country;

    @Column(name = "district", length = 20, nullable = false)
    private String districtName;

    @Column(name = "population", nullable = false)
    private int populationCount;

    public City() {
    }

    public City(String name,
                Country country,
                String districtName,
                int populationCount) {
        this.name = name;
        this.country = country;
        this.districtName = districtName;
        this.populationCount = populationCount;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public String getDistrictName() {
        return districtName;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof City otherCity
                && Objects.equals(identifier, otherCity.identifier)
                && Objects.equals(name, otherCity.name)
                && Objects.equals(country, otherCity.country)
                && Objects.equals(districtName, otherCity.districtName)
                && Objects.equals(populationCount, otherCity.populationCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, name, country, districtName, populationCount);
    }

    @Override
    public String toString() {
        return name;
    }
}
