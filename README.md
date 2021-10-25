## About
This repository contains a small demo RESTful web application for the MySQL "World" sample database.
It is built using various modules of the Spring framework.

## Usage

### Cities
* `GET /cities/{ID}` returns a city of the specified ID, e.g. `GET /cities/42`
* `GET /cities` returns all recorded cities (warning: response might be relatively sizeable)
* `GET /cities?country={ALPHA_3}` returns all cities belonging to the country specified by an [ISO 3166-1 alpha-3 country code](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3), i.e. `GET /cities?country=FRA` would return all cities of France

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
* `GET /countries/{ALPHA_3}` returns a country of the specified alpha-3 code, e.g. `GET /countries/FRA`
* `GET /countries` returns all recorded cities
* `GET /countries?continent={CONTINENT_NAME}` returns all countries belonging to the specified continent, where valid values are: `Asia`, `Europe`, `North America`, `Africa`, `Oceania`, `Antarctica` and `South America` (all case-sensitive)

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
* `GET /languages/{NAME}` returns a list of languages with the specified name (dialects and other related "distinctions" are seen as separate languages, i.e. a language spoken in 2 different countries is seen as 2 different languages)
* `GET /languages` returns all recorded languages
* `GET /languages?country={ALPHA_3}` returns all languages that are spoken in the country specified by an alpha-3 code

Response example:
```json
[
    {
        "name": "Finnish",
        "country": "Estonia",
        "official": false,
        "percentage": 0.7
    },
    {
        "name": "Finnish",
        "country": "Finland",
        "official": true,
        "percentage": 92.7
    },
    {
        "name": "Finnish",
        "country": "Sweden",
        "official": false,
        "percentage": 2.4
    }
]
```

All endpoints return an HTTP OK status code on a successful response.

## Build
*Coming soon™*

## Run

### Prerequisites
Before you can run the application, you'll have to specify a DB user's username and password for access. One way to do
so is via an `application.properties` configuration file. A minimal template is included in this repository and is
located at `src/main/resources/application.properties`. Simply assign the values (*without* quotation marks) to their
respective properties, names of which should be pretty self-explanatory.

Example:
```properties
spring.datasource.username=admin
spring.datasource.password=admin
```

The DB URL is initially set to `localhost` on MySQL's default port, and if needed can be customized as well. Refer to
the Spring and MySQL docs for more information.

## License
This software is distributed under the [MIT license](LICENSE).