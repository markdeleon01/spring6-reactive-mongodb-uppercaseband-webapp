# Spring6 Reactive WebFlux REST backend web application for UPPERCASE band

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/markdeleon01/spring6-webflux.fn-mongodb-uppercaseband-webapp/tree/main.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/markdeleon01/spring6-webflux.fn-mongodb-uppercaseband-webapp/tree/main)

[![codecov](https://codecov.io/gh/markdeleon01/spring6-webflux.fn-mongodb-uppercaseband-webapp/graph/badge.svg?token=IJQ8DOYDLQ)](https://codecov.io/gh/markdeleon01/spring6-webflux.fn-mongodb-uppercaseband-webapp)


This repository is for a RESTful web application built on Spring6 Reactive WebFlux Framework for my band's website.

This is a Spring Boot 3 web application that serves up articles regarding the UPPERCASE band.

The articles are categorized and displayed according to the various sections of the website,
such as highlights on the home page, events, discography section, and band information section;
they are stored and retrieved as documents from an embedded MongoDB NoSQL database.

The article resources are exposed with the API route:
http://localhost:8080/api/v2/articles

JUnit5 tests were written to assert functionalities of the repository, service, and controller classes.

## Project setup

1. Install Java SE 17 LTS:
   https://www.oracle.com/java/technologies/downloads/#java17
2. Install Apache Maven:
   https://maven.apache.org/download.cgi
3. Install MongoDB:  https://www.mongodb.com/docs/manual/installation/
4. Clone this project repository
5. Navigate to the project folder and install
   ```sh
   mvn compile
   mvn test
   mvn verify
   mvn package
   ```
6. Run the web application
   ```sh
   java -jar target/spring6-reactive-mongodb-uppercaseband-webapp-0.0.1-SNAPSHOT.jar
   ```
7. Open a browser window and navigate to: http://localhost:8080/api/v2/articles
8. Download the Postman desktop app:  https://www.postman.com
9. Use the Postman desktop app to access the exposed APIs.
10. Open the Swagger UI / Open API definition: http://localhost:8080/swagger-ui.html