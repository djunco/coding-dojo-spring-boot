# Spring Boot Coding Dojo

Welcome to the Spring Boot Coding Dojo!

## Introduction

This is a simple application that requests its data from [OpenWeather](https://openweathermap.org/) and stores the result in a database. 

## Getting Started
### Prerequisites
* Java SDK 11
* Maven 3.6.0
### Installing
From the project root folder command line run the following command to build the application
```
./mvnw clean install
```

Run the database migration job with the proper values for db_host, db_name, db_username and db_password
```
./mvnw liquibase:update -Ddb_host=localhost:5432 -Ddb_name=weather -Ddb_username=user -Ddb_password=password
```

Run the application with the proper values for db_host, db_name, db_username, db_password and apikey:
```
./mvnw spring-boot:run -Dspring-boot.run.arguments=--db_host=localhost:5432,--db_name=weather,--db_username=user,--db_password=password,--apikey=key
```
### Usage

Search weather data for a determined city:
```
curl -X GET "http://localhost:8080/weather?city=amsterdam"
```

## Running the tests

From the project root folder, run the command ```./mvnw verify``` to execute:
 * Unit tests
 * JaCoCo code coverage test
 * JaCoCo test reports
 * Google Java style check

JaCoCo is setup to have a minimum code coverage ratio of 90%. Anything lower will fail in the build phase as a code quality enforcement policy

After execution JaCoCo test reports can be found in ```/target/site/jacoco/index.html``` 

## Built With

* [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) - Language
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework
* [Swagger2](https://swagger.io/) - REST API documentation [Documentation](http://localhost:8080/)
* [Lombok](https://projectlombok.org/) - Java library to write less code
* [JaCoCo](https://www.eclemma.org/jacoco/) - Java Code Coverage Library
* [JUnit](https://junit.org) - Testing
* [MockMvc](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/MockMvc.html) - Testing
* [Liquibase](https://www.liquibase.org/) - Database management

## Authors

* **[Diego Junco](mailto:djunco@mobiquityinc.com)**

### Footnote
It's possible to generate the API key going to the [OpenWeather Sign up](https://openweathermap.org/appid) page.
