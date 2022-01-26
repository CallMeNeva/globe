## About
**Globe** is an extremely simple semi-RESTful web API for the MySQL
[World](https://dev.mysql.com/doc/world-setup/en/world-setup-installation.html) sample database.

## Usage
General API notes:
* Most response status codes are not explicitly defined and are provided by the underlying framework
* If a requested list of items was not found, an empty list is returned instead of a `404`
* Due to the project's simplicity, pagination is currently not implemented. This means that large responses will go through as-is, i.e.
  `GET /cities` (for instance) will quite literally return all the cities present in the database in one big response

### Cities
* `GET /cities` returns all cities that exist in the world
* `GET /cities/most-populated` returns the most populated city in the world
* `GET /cities/least-populated` returns the least populated city in the world
* `GET /cities/$(ALPHA_3)` returns all cities of the specified country, where `$(ALPHA_3)` is the country's
  [ISO 3166-1 alpha-3](https://www.iso.org/iso-3166-country-codes.html) code (e.g. `GET /cities/FIN`)
* `GET /cities/$(ALPHA_3)/most-populated` returns the most populated city in the specified country
* `GET /cities/$(ALPHA_3)/least-populated` returns the least populated city in the specified country

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
* `GET /countries` returns all countries that exist in the world
* `GET /countries/most-populated` returns the most populated country in the world
* `GET /countries/least-populated` returns the least populated country in the world
* `GET /countries/largest` returns the largest (in terms of surface area) country in the world
* `GET /countries/smallest` returns the smallest (in terms of surface area) country in the world
* `GET /countries/$(CONTINENT_NAME)` returns all countries of the specified continent, where `$(CONTINENT_NAME)` is one of the following
  values (case-sensitive): `Asia`, `Europe`, `North America`, `South America`, `Africa`, `Oceania` and `Antarctica` (e.g.
  `GET /countries/Europe`)
* `GET /countries/$(CONTINENT_NAME)/most-populated` returns the most populated country on the specified continent
* `GET /countries/$(CONTINENT_NAME)/least-populated` returns the least populated country on the specified continent
* `GET /countries/$(CONTINENT_NAME)/largest` returns the largest (in terms of surface area) country on the specified continent
* `GET /countries/$(CONTINENT_NAME)/smallest` returns the smallest (in terms of surface area) country on the specified continent

Response example:
```json
{
  "name": "Finland",
  "localName": "Suomi",
  "alpha2": "FI",
  "capital": "Helsinki [Helsingfors]",
  "continent": "Europe",
  "region": "Nordic Countries",
  "surfaceArea": 338145,
  "governmentForm": "Republic",
  "headOfState": "Tarja Halonen",
  "independenceYear": "1917",
  "population": 5171300,
  "lifeExpectancy": 77.4,
  "GNP": 121914,
  "oldGNP": 119833
}
```

### Languages
* `GET /languages` returns all languages that exist in the world
* `GET /languages/$(ALPHA_3)` returns all languages spoken in the specified country
* `GET /languages/$(ALPHA_3)/official` returns all official languages of the specified country
* `GET /languages/$(ALPHA_3)/unofficial` returns all unofficial languages of the specified country
* `GET /languages/$(ALPHA_3)/most-popular` returns the most popular language in the specified country
* `GET /languages/$(ALPHA_3)/least-popular` returns the least popular language in the specified country

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
Before you can build, make sure your `JAVA_HOME` environment variable points to a JDK v17. Then simply run the Maven wrapper as follows 
(if you're on a *nix system, you might also need to make the script executable with a `chmod +x`):

```shell
./mvnw package
```

or 

```shell
mvnw.cmd package
```

if you're on Microsoft Windows.

For more information refer to the [Maven wrapper documentation](https://maven.apache.org/wrapper/).

You should now have an executable JAR located in the generated `target/` directory, such as `target/globe-1.4.0.jar`. To execute it, simply
run `java -jar target/globe-1.4.0.jar`.

When running the application, DB username and password must be provided. One way to do so is via the `--user` and `--password` CLI
arguments, i.e. `java -jar target/globe-1.4.0.jar --user=admin --password=admin`. Another way is to specify these values in the
`application.properties` file, located in `src/resources/` (a rebuild is required if you choose this option).

Additional (optional) parameters include:
* `host` — to specify the DB host (default value: `localhost:3306`)
* `prettify` — to enable/disable formatting of response JSON (default value: `false`)

## License
This software is distributed under an [MIT license](LICENSE).
