package io.github.altoukhovmax.worldapi.entity;

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
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public int getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(int populationCount) {
        this.populationCount = populationCount;
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj) || (obj instanceof City otherCity
                && Objects.equals(id, otherCity.id)
                && Objects.equals(name, otherCity.name)
                && Objects.equals(country, otherCity.country)
                && Objects.equals(districtName, otherCity.districtName)
                && Objects.equals(populationCount, otherCity.populationCount));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, districtName, populationCount);
    }

    @Override
    public String toString() {
        return name;
    }
}
