# student-springboot-crud-operation
[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 17](https://jdk.java.net/17/)
- [Maven](https://maven.apache.org/download.cgi)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.demo.FirstSpringPrApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## Structure

Student.java => Student Data Model and mapping into sql database.

StudentController.java => Generate all CRUD opperation to call from client side.

StudentService.java => Implement some business logic and  manage student class.

StudentRepository.java => This class is responsible to get data from a database.

StudentConfiguration.java => I use CommandLineRunner interface that run a code contain some instance of Student class with a mock data for testing ,
and call repository class to save them into database

