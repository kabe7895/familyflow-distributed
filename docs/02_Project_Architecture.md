# FamilyFlow – Project Architecture

## 1. Overview

FamilyFlow is designed as a **distributed application** consisting of multiple independent components.

The system separates:

- User interaction
- Business logic
- Data persistence
- Background services

into individual modules.

The architecture consists of the following components:

| Component | Description |
|---|---|
| React Frontend | User interface and client application |
| Spring Boot Backend | Business logic and REST API |
| Notification Service | Independent background service |
| PostgreSQL Database | Persistent data storage |

The goal of this architecture is to separate user interaction, business logic, persistence, and notification processing into independent components.
---

# 2. System Architecture

The overall system communication follows this structure:

```text
                 User

                  |

                  v

          React Frontend

                  |

                  | REST API

                  v

          Backend Service
             Port: 8080

                  |

        +---------+---------+
        |                   |
        | JPA / Hibernate   | HTTP REST
        v                   v

 PostgreSQL Database   Notification Service
                            Port: 8082
```

# 3. System Components

## 3.1 Frontend

The frontend provides the user interface for interacting with FamilyFlow.
The frontend is implemented as a **React Single Page Application** using **Vite**.

### Responsibilities

- User interface
- User interaction
- Displaying family data
- Sending HTTP requests to the backend API

## Technology

- React
- Vite

### Communication

The frontend communicates with the backend using:

```
HTTP REST API
```

### Example Requests

```http
GET /families

POST /families
```

---

# 3.2 Backend Service

The Backend Service contains the core application logic.
The backend is implemented using **Spring Boot**.

## Responsibilities

- Manage families
- Manage members
- Manage tasks
- Provide REST API endpoints
- Validate incoming requests
- Handle application errors
- Persist data
- Communicate with external services
    - Communication with the database
    - Communication with distributed services

---

## Technology

The backend is implemented using:

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL

---

## Backend Layer Architecture

The backend follows a layered architecture:

```text
Controller Layer
        |
        |
        v
Service Layer
        |
        |
        v
Repository Layer
        |
        |
        v
Entity Layer
        |
        |
        v
   PostgreSQL Database
```

---

## Controller Layer

Responsible for:

- Receiving HTTP requests
- Returning HTTP responses
- Mapping requests to services

---

## Service Layer

Responsible for:

- Implementing business logic
- Processing application rules
- Coordinating between components

---

## Repository Layer

Responsible for:

- Database communication
- CRUD operations
- Using Spring Data JPA

---

# 3.3 Notification Service (Distributed Component)

The Notification Service is implemented as an **independent Spring Boot application**.

Responsibilities:

- Receive notification events
- Process notifications independently from the backend
- Separate notification functionality from business logic


## Technology

- Java 21
- Spring Boot


The service runs independently on:

```text
Port: 8082
```


---

It runs as a separate process with:

- Own application context
- Own lifecycle
- Own network port

---

## Configuration

| Property | Value |
|---|---|
| Service Name | notification-service |
| Port | 8082 |

---

## Purpose

The Notification Service handles notification events independently from the main backend.

---

## Example Event

```text
FAMILY_CREATED
```

When a new family is created:

1. The backend stores the family information in PostgreSQL.
2. The backend sends an HTTP request to the Notification Service.
3. The Notification Service receives and processes the event.

---

# 5. Database

## PostgreSQL

PostgreSQL is used as the persistent storage system.

Responsibilities:

- Store family data
- Store member data
- Store task data
- Provide reliable persistence


The backend communicates with PostgreSQL using:

- Spring Data JPA
- Hibernate ORM


---

# Distributed Communication

The Backend Service and Notification Service communicate through HTTP REST requests.

Both services:

- Run independently
- Have separate application contexts
- Use separate ports
- Communicate through network requests


This means FamilyFlow consists of multiple cooperating processes.


---

## Communication Example

When a new family is created:

1. The user creates a family through the frontend.
2. The frontend sends a REST request to the Backend Service.
3. The Backend Service stores the family in PostgreSQL.
4. The Backend Service creates a notification event.
5. The event is sent to the Notification Service.
6. The Notification Service receives and processes the event.


Example event:

```json
{
  "type": "FAMILY_CREATED",
  "message": "Family created: DistributedTest3"
}
```


---

# Proof of Execution

The distributed communication was successfully tested.


## Backend Service Output

```text
Sending notification to service

Type: FAMILY_CREATED
Message: Family created: DistributedTest3

Notification sent
```


## Notification Service Output

```text
Notification received

Type: FAMILY_CREATED
Message: Family created: DistributedTest3
```



# 4. Distributed Architecture

The Notification Service is **not part of the backend process**.

Both services:

- Run independently
- Have separate application contexts
- Use separate ports
- Communicate through network requests

Therefore, the system consists of multiple cooperating processes.

---


# 6. Technology Overview

## Architectural Benefits

The distributed architecture provides:

- Separation of responsibilities
- Independent service development
- Better maintainability
- Easier future extensions
- Possibility for independent scaling


---
## Components used

| Component | Technology |
|---|---|
| Frontend | React 19 + Vite |
| Backend | Spring Boot 3.5 |
| Programming Language | Java 17 |
| Notification Service | Spring Boot |
| Database | PostgreSQL |
| Communication | HTTP REST API |
| Persistence | Spring Data JPA / Hibernate |

---

# 7. Future Extensions

Possible future extensions:

- Android application
- Push notification service
- Authentication service
- Calendar service
- AI integration service

The current architecture allows additional services to be added without changing the existing components.


# 8. Conclusion

FamilyFlow fulfills the requirements of a distributed software system.

Multiple independent processes communicate through REST-based network communication to complete application tasks.

The architecture provides a solid foundation for future extensions such as:

- Android application
- Authentication and authorization
- Additional services
- Advanced notification features