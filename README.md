# familyflow-distributed

Distributed FamilyFlow application using Spring Boot, Android and PostgreSQL.

## Current Status

The backend foundation has been created successfully.

Implemented:

- Spring Boot backend project setup
- Maven project configuration
- PostgreSQL database connection
- Spring Data JPA integration
- First REST endpoint for backend health checks

## Backend Technology Stack

- Java 21
- Spring Boot 3.5.16
- Maven
- Spring Web
- Spring Data JPA
- PostgreSQL 18
- Hibernate ORM

## Project Structure
familyflow-distributed
│
├── backend
│ ├── src/main/java
│ │ └── de.familyflow.backend
│ │ ├── BackendApplication.java
│ │ └── controller
│ │ └── HealthController.java
│ │
│ └── src/main/resources
│ └── application.properties
│
└── README.md

## Database

The backend is connected to a PostgreSQL database.

Database:
- PostgreSQL 18
- Database name: `familyflow`

The database connection is configured using environment variables:
DB_PASSWORD

The password is not stored directly in the project configuration.

## Running the Backend

Navigate to the backend folder:

```bash
cd backend
Start the Spring Boot application:

mvn spring-boot:run

The backend starts on:

http://localhost:8080
Health Check

A first test endpoint is available:

GET /health
## Development Notes

The initial backend setup included the following steps:

- Configured the Spring Boot backend project structure
- Renamed the project package and application classes from `beckend` to `backend`
- Connected the backend application to PostgreSQL
- Configured database access using environment variables
- Verified successful Spring Boot startup
- Implemented the first REST endpoint for backend health monitoring

## Next Steps

Planned development steps:

- Create the first database entities and JPA models
- Implement REST APIs for user management
- Add validation and business logic
- Introduce authentication and authorization
- Connect the Android client with the backend API
- Extend the application towards a distributed system architecture

## Database Persistence

The first JPA entity has been implemented.

Current database model:

- Entity: Member
- Table: members

Hibernate automatically creates the database schema during application startup.

Verified:
- PostgreSQL connection successful
- JPA repository initialized
- Table creation completed

## Backend Status

The Spring Boot backend is connected to PostgreSQL and provides a first REST API.

Implemented:

- Spring Boot application setup
- PostgreSQL database connection
- JPA/Hibernate configuration
- Member entity
- Member repository
- Member service layer
- Member REST controller

First REST endpoints:

GET /members

Returns all stored members.

POST /members

Creates a new member and stores it in PostgreSQL.

Example:

{
  "name": "Max Mustermann",
  "email": "max@example.com"
}

Test result:

[
  {
    "id": 1,
    "name": "Max Mustermann",
    "email": "max@example.com"
  }
]

## Current Status

Backend foundation completed:

- Spring Boot backend setup
- PostgreSQL integration
- First JPA entity (Member)
- Repository-Service-Controller architecture
- REST API for members
- Verified database persistence