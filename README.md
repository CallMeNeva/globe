## About
This project represents a small and extremely simple demo web application that exposes the MySQL
[World](https://dev.mysql.com/doc/world-setup/en/world-setup-installation.html) sample database via a RESTful API, powered by Spring Boot
and Java 17.

## Usage
**Note:** Due to the project's simplicity there is no pagination functionality implemented whatsoever. This means that large responses will
go through as-is, e.g. `GET /cities` will quite literally return all the cities present in the database.

### Cities
* `GET /cities` returns all recorded cities. The `country` parameter can be used to filter out cities of a specific country, where valid 
  values are [ISO 3166-1 alpha-3](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3) country codes, e.g. `GET /cities?country=FRA`;
* `GET /cities/{ID}` returns a city of the specified ID, e.g. `GET /cities/42`;
* `GET /cities/most-populated` and `GET /cities/least-populated` return the most and least populated cities respectively.

Response example:
```json
{
    "name": "Dijon",
    "country": "France",
    "district": "Bourgogne",
    "population": 149867
}
```

### Countries
* `GET /countries` returns all recorded countries. The `continent` parameter can be used to filter out countries of a specific continent,
  where valid values are: `Asia`, `Europe`, `North America`, `Africa`, `Oceania`, `Antarctica` and `South America` (all case-sensitive), 
  e.g. `GET /countries?continent=Europe`;
* `GET /countries/{ALPHA_3}` returns a country of the specified alpha-3 code, e.g. `GET /countries/FRA`;
* `GET /countries/most-populated` and `GET /countries/least-populated` return the most and least populated countries respectively;
* `GET /countries/largest` and `GET /countries/smallest` return the largest and smallest (in terms of surface area) countries respectively.

Response example:
```json
{
    "name": "Spain",
    "localName": "España",
    "alpha2Code": "ES",
    "capital": "Madrid",
    "continent": "Europe",
    "region": "Southern Europe",
    "surfaceArea": 505992,
    "governmentForm": "Constitutional Monarchy",
    "headOfState": "Juan Carlos I",
    "independenceYear": "1492",
    "population": 39441700,
    "lifeExpectancy": 78.8,
    "GNP": 553233,
    "oldGNP": 532031
}
```

### Languages
* `GET /languages` returns all recorded languages. The `country` parameter can be used to filter out languages of a specific country, where 
  valid values are alpha-3 country codes.

Response example:
```json
[
    {
        "name": "English",
        "country": "Malta",
        "official": true,
        "percentage": 2.1
    },
    {
        "name": "Maltese",
        "country": "Malta",
        "official": true,
        "percentage": 95.8
    }
]
```

## Self-Hosting
### Prerequisites
Before you can run the application, you'll have to specify a DB user's username and password for access. One way to do so is via an
`application.properties` configuration file. A minimal template is included in this repository and is located at
`src/main/resources/application.properties`. Simply assign the values (*without* quotation marks) to their respective properties, names of
which should be pretty self-explanatory.

Example:
```properties
spring.datasource.username=admin
spring.datasource.password=admin
```

The DB URL is initially set to `localhost` on MySQL's default port, and if needed can be customized as well. Refer to
the Spring and MySQL docs for more information.

### Running
The only tools that are needed are a JDK of version 17+ and an appropriately recent enough version of Maven. Once these requirements are
met, simply follow these steps:

1. Clone this repository
   ```shell
   git clone https://github.com/altoukhov-max/mysql-world-api.git
   cd mysql-world-api
   ```
2. Build and package the source code as an executable JAR file
   ```shell
   mvn package
   ```
3. Run the resulting JAR file
   ```shell
   java -jar target/world-api-1.1.0.jar
   ```

## License
This software is distributed under the [MIT license](LICENSE).
