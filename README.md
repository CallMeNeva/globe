## About
**Globe** is an extremely simple (a bit primitive, even) RESTful web API for the MySQL
[World](https://dev.mysql.com/doc/world-setup/en/world-setup-installation.html) sample database.

## Usage
General API notes:
* All requests for a specific entity return `OK` (with a body) if one was found and an empty `Not Found` otherwise;
* All requests for a list of entities return `OK` with a valid body - if no entities were found, the body is simply an empty list;
* Any other types of responses are provided by the underlying framework and should not be depended upon by the client;
* Due to the project's simplicity, there is currently no pagination functionality implemented. This means that large responses will go
  through as-is, e.g. `GET /cities` will quite literally return all the cities present in the database in one response.

### Cities
* `GET /cities` returns all recorded cities. The `country` parameter can be used to filter out cities of a specific country, where valid
  values are [ISO 3166-1 alpha-3](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3) country codes, e.g. `GET /cities?country=FRA`;
* `GET /cities/most-populated` and `GET /cities/least-populated` return the most and least populated cities (globally) respectively. The
  `country` parameter can be used to narrow down the scope to a specific country.

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
* `GET /countries/most-populated` and `GET /countries/least-populated` return the most and least populated countries (globally)
  respectively. The `continent` parameter can be used to narrow down the scope to a specific continent;
* `GET /countries/largest` and `GET /countries/smallest` return the countries with the largest and smallest surface area (globally)
  respectively. The `continent` parameter can be used to narrow down the scope to a specific continent.

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
* `GET /languages` returns all recorded languages. The `country` parameter can be used to filter out languages of a specific country, where
  valid values are alpha-3 country codes;
* `GET /languages/official?country={ALPHA_3}` and `GET /languages/unofficial?country={ALPHA_3}` return all official and unofficial languages
  of the specified country respectively (parameter is required);
* `GET /languages/most-popular?country={ALPHA_3}` and `GET /languages/least-popular?country={ALPHA_3}` return the most and least popular
  languages of the specified country respectively (parameter is required).

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
Before you can build, make sure your `JAVA_HOME` environment variable points to a JDK 17. Then simply run the Maven wrapper as follows 
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
- `host` — to specify the DB host (default value: `localhost:3306`)
- `prettify` — to enable/disable formatting of response JSON (default value: `false`)

## License
This software is distributed under an [MIT license](LICENSE).
