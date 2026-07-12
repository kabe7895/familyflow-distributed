# FamilyFlow Distributed

A distributed family management platform that enables families to organize members, tasks, and daily activities using a modern multi-service architecture.

---

# Project Overview

FamilyFlow is a distributed software system developed as a proof-of-concept for managing family-related information.

The application separates user interaction, business logic, notification processing, and data persistence into independent components.

Current functionality includes:

- Family management
- Member management
- Task management
- REST API
- PostgreSQL persistence
- Distributed notification service

The project follows a modular architecture that can easily be extended with additional services and clients.

---

# Distributed Architecture

FamilyFlow consists of multiple independent processes communicating through REST-based network requests.

```text
                    User
                      |
                      v
              React Frontend
                      |
                  REST API
                      |
                      v
          Backend Service (8080)
              |              |
      JPA / Hibernate     HTTP REST
              |              |
              v              v
     PostgreSQL Database   Notification Service (8082)
```

## Components

| Component | Responsibility |
|-----------|----------------|
| React Frontend | User interface |
| Backend Service | Business logic and REST API |
| Notification Service | Independent event processing |
| PostgreSQL | Persistent data storage |

The Backend Service and Notification Service are separate Spring Boot applications with independent application contexts, ports, and responsibilities.

When a new family is created, the backend stores the data in PostgreSQL and sends a notification event to the Notification Service, demonstrating distributed communication between independent processes.

---

# Technology Stack

## Backend

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- Hibernate
- Spring Validation
- Springdoc OpenAPI (Swagger)
- Maven

## Frontend

- React
- Vite
- JavaScript (JSX)

## Database

- PostgreSQL

## Additional Service

- Spring Boot Notification Service

---

# Project Structure

```text
familyflow-distributed/

├── backend/
│   ├── family/
│   ├── member/
│   ├── task/
│   ├── notification/
│   └── config/
│
├── notification-service/
│
├── frontend/
│
├── database/
│
└── docs/
    ├── 01_Project_Setup.md
    ├── 02_Project_Architecture.md
    ├── 03_Member_Module.md
    ├── 04_Family_Module.md
    ├── 05_Task_Module.md
    ├── 06_Development_Steps.md
    ├── 07_Development_Tools.md
    └── backend/
```

---

# Features

## Backend

- RESTful API
- Layered Spring Boot architecture
- DTO layer
- Input validation
- Global exception handling
- Swagger API documentation
- Global CORS configuration
- PostgreSQL persistence

## Modules

- Family Management
- Member Management
- Task Management

## Distributed System

- Independent Notification Service
- REST-based service communication
- Separate application contexts
- Separate runtime processes

---

# Getting Started

## Prerequisites

Install the following software:

- Java 21
- Maven
- Node.js and npm
- PostgreSQL

Configure the PostgreSQL connection in:

```text
backend/src/main/resources/application.properties
```

---

## 1. Start PostgreSQL

Make sure the PostgreSQL server is running.

---

## 2. Start the Notification Service

```bash
cd notification-service
mvn spring-boot:run
```

The service starts on:

```text
http://localhost:8082
```

---

## 3. Start the Backend

```bash
cd backend
mvn spring-boot:run
```

The backend starts on:

```text
http://localhost:8080
```

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 4. Start the Frontend

```bash
cd frontend
npm install
npm run dev
```

The frontend starts on:

```text
http://localhost:5173
```

---

# Distributed Communication Example

When a new family is created:

1. The frontend sends a REST request to the Backend Service.
2. The Backend Service stores the family in PostgreSQL.
3. A notification event is created.
4. The event is sent to the Notification Service.
5. The Notification Service processes the event independently.

Example backend log:

```text
Sending notification to service

Type: FAMILY_CREATED
Message: Family created: DistributedTest3

Notification sent
```

Example notification service log:

```text
Notification received

Type: FAMILY_CREATED
Message: Family created: DistributedTest3
```

---

# Documentation

Detailed project documentation is available in the `docs` directory.

## Main Documentation

- `docs/01_Project_Setup.md`
- `docs/02_Project_Architecture.md`
- `docs/03_Member_Module.md`
- `docs/04_Family_Module.md`
- `docs/05_Task_Module.md`
- `docs/06_Development_Steps.md`
- `docs/07_Development_Tools.md`

## Backend Documentation

- `docs/backend/01_Database_Verification.md`
- `docs/backend/02_First_Member_API.md`
- `docs/backend/03_CRUD_Operations.md`
- `docs/backend/04_Input_Validation.md`
- `docs/backend/05_Exception_Handling.md`
- `docs/backend/06_Swagger_API_Documentation.md`
- `docs/backend/07_CORS_Configuration.md`
- `docs/backend/08_DTO_Layer_Implementation.md`
- `docs/backend/09_Task_Module_API.md`

---

# Future Work

Planned extensions include:

- Android application
- Authentication and authorization
- User roles and permissions
- Calendar management
- Push notifications
- Additional distributed services

---

# License

This project was developed for educational purposes as part of a software engineering project.