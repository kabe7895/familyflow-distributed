# Family Flow Distributed

A distributed family management platform enabling families to organize members, tasks, and data efficiently.

## Project Overview

Family Flow provides a central, distributed platform designed to help families manage their daily organization. The application is built with a modular approach, separating concerns between a robust Java backend, a modern React frontend, and a relational PostgreSQL database.

## Architecture

The project follows a classic client-server architecture:

- **Frontend**: A Single Page Application (SPA) built with React 19 and Vite. It utilizes manual state-based routing to provide a fast and responsive user experience.
- **Backend**: A modular Spring Boot 3.5 application running on Java 17. It exposes RESTful APIs for frontend consumption, handles business logic, and manages database persistence via Spring Data JPA.
- **Database**: PostgreSQL handles persistent storage, with Hibernate managing schema synchronization dynamically.

## Technology Stack

### Backend
- **Framework**: Spring Boot 3.5.16
- **Language**: Java 17
- **Database Access**: Spring Data JPA / Hibernate
- **Validation**: Spring Boot Starter Validation
- **Documentation**: Springdoc OpenAPI (Swagger)

### Frontend
- **Framework**: React 19
- **Build Tool**: Vite 8
- **Language**: JavaScript/JSX

### Infrastructure
- **Database**: PostgreSQL

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Version 17 or higher.
- **Node.js**: Version 20 or higher.
- **PostgreSQL**: A running instance.
- **Environment Variables**:
  - `DB_PASSWORD`: Set this environment variable to your PostgreSQL password.

### Running the Backend

1. Navigate to the `backend` directory:
   ```bash
   cd backend
   ```
2. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. The API will be available at `http://localhost:8080`.
4. API documentation can be accessed at `http://localhost:8080/swagger-ui/index.html`.

### Running the Frontend

1. Navigate to the `frontend` directory:
   ```bash
   cd frontend
   ```
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm run dev
   ```
4. Access the application at the URL provided by Vite (usually `http://localhost:5173`).

## Project Structure

```text
├── backend/          # Spring Boot application
├── frontend/         # React SPA
├── docs/             # Comprehensive technical documentation
└── database/         # SQL/migration scripts (placeholders)
```

## Development Guidelines

For detailed information on project setup, API definitions, and development workflows, refer to the documentation in the `docs/` directory:

- [Project Setup](docs/01_Project_Setup.md)
- [API Documentation](docs/07_Swagger_API_Documentation.md)
- [Member Module](docs/03_First_Member_API.md)


# FamilyFlow Distributed - Start Guide

## Project Overview

FamilyFlow is a distributed application consisting of multiple independent modules:

- React Frontend
- Spring Boot Backend Service
- Spring Boot Notification Service
- PostgreSQL Database

The backend and notification service run as separate processes and communicate via REST.

---

# Requirements

Installed:

- Java 21
- Maven
- Node.js / npm
- PostgreSQL

---

# Start the Application

The application consists of three running services.

## 1. Start Database

Make sure PostgreSQL is running.

The backend connects to the PostgreSQL database configured in:


backend/src/main/resources/application.properties


---

## 2. Start Notification Service

Open a terminal:

```powershell
cd notification-service
mvn spring-boot:run

The service starts on:

http://localhost:8082

The notification service receives events from the backend.

Example:

Type: FAMILY_CREATED
Message: Family created: ExampleFamily
3. Start Backend Service

Open a second terminal:

cd backend
mvn spring-boot:run

The backend starts on:

http://localhost:8080

Responsibilities:

Family management
Task management
Database communication
Communication with notification service
4. Start Frontend

Open a third terminal:

cd frontend
npm install
npm run dev

The frontend starts with Vite:

http://localhost:5173
Distributed Communication Test

To verify the distributed architecture:

Open the frontend.
Create a new family.
The backend stores the family in PostgreSQL.
The backend sends a REST request to the notification service.
The notification service processes the event.

Example backend output:

>>> Sending notification to service
Type: FAMILY_CREATED
Message: Family created: DistributedTest3
>>> Notification sent

Example notification-service output:

Notification received

Type: FAMILY_CREATED
Message: Family created: DistributedTest3
Project Structure
familyflow-distributed

├── backend
│   └── Spring Boot REST API
│
├── notification-service
│   └── Independent Spring Boot Service
│
├── frontend
│   └── React/Vite GUI
│
├── database
│   └── PostgreSQL configuration
│
└── docs
    ├── google-stitch-prompts.md
    ├── distributed-architecture.md
    └── screenshots
Development Approach

The project was developed step-by-step.

Documentation files in /docs describe:

UI design process
Google Stitch prompts
Distributed architecture
Development steps