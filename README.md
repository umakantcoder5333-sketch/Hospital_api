# Hospital_api

I'm building this Hospital REST API with Spring Boot and MySQL to practice and implement real-world backend development concepts.

## Features

- Patient CRUD operations
- Create, read, update, and delete patients
- Request and response DTOs
- Input validation
- Global exception handling
- Custom patient not found exception
- MySQL database integration
- Spring Data JPA
- REST APIs

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Jakarta Validation

## Project Structure

```text
Hospital_api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.Hospital_api
│   │   │       ├── config
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── entity
│   │   │       ├── exception
│   │   │       ├── repository
│   │   │       └── service
│   │   └── resources
│   │       └── application.properties
│   └── test
├── pom.xml
└── README.md
