# Task Module

## Overview

The **Task module** manages tasks within the **FamilyFlow** application.

A task represents an activity or responsibility that can be managed within a family context.

The module currently provides functionality for:

- Creating tasks
- Storing tasks in the database
- Retrieving task data
- Managing task state


---

# Backend Structure

The Task module follows the **layered Spring Boot architecture**.

The implementation is separated into different responsibility layers:

```text
task
│
├── Task.java
├── TaskRepository.java
├── TaskService.java
│
└── dto
    │
    ├── TaskRequestDTO.java
    └── TaskResponseDTO.java
```

### Layer Responsibilities

| Layer | Responsibility |
|---|---|
| Entity | Represents the database model |
| Repository | Handles database access using Spring Data JPA |
| Service | Contains business logic |
| DTO | Transfers data between application layers |


---

# Entity

A task contains the following attributes:

| Attribute | Description |
|---|---|
| `id` | Unique identifier |
| `title` | Title of the task |
| `description` | Detailed description of the task |
| `completed` | Indicates whether the task has been completed |

Example task:

```json
{
  "title": "Buy groceries",
  "description": "Purchase food and household items",
  "completed": false
}
```


The entity is mapped to the PostgreSQL database using:

- Spring Data JPA
- Hibernate ORM


Database table:

```text
tasks
```

The primary key is automatically generated using:

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```


---

# Service Layer

The `TaskService` contains the business logic for task management.

Responsibilities include:

- Creating task objects
- Processing task operations
- Applying application logic before database interaction


The service layer separates business logic from persistence and API layers.


---

# Repository Layer

The `TaskRepository` provides database access for task entities.

It uses:

```text
Spring Data JPA Repository
```

Responsibilities:

- Saving tasks
- Retrieving tasks
- Updating tasks
- Deleting tasks


---

# Data Transfer Objects (DTO)

The Task module uses DTO classes to separate internal entities from external data transfer.

Implemented DTOs:

```text
TaskRequestDTO.java

TaskResponseDTO.java
```

Responsibilities:

| DTO | Purpose |
|---|---|
| `TaskRequestDTO` | Receives task data from clients |
| `TaskResponseDTO` | Provides task data as response objects |


---

# REST API Status

The Task module currently does **not provide a REST Controller**.

Current implementation status:

| Component | Status |
|---|---|
| Entity | Implemented |
| Repository | Implemented |
| Service | Implemented |
| DTOs | Implemented |
| REST Controller | Not implemented |

The module is therefore prepared for future API integration.


---

# Database Persistence

Tasks are stored persistently in the PostgreSQL database.

The persistence flow:

```text
Task Entity

      |

TaskRepository

      |

Hibernate / JPA

      |

PostgreSQL Database
```


---

# Testing

Implemented functionality includes:

- Entity creation
- Database mapping
- Repository integration
- Service layer preparation


The module demonstrates the implementation of a persistent domain component following the layered Spring Boot architecture.


---

# Documentation Structure

Current documentation structure:

```text
docs
│
├── 01_Project_Setup.md
├── 02_Project_Architecture.md
├── 03_Member_Module.md
├── 04_Family_Module.md
├── 05_Task_Module.md
├── 06_Development_Steps.md
├── 07_CLI_Tools.md
│
└── backend
    │
    ├── 01_Database_Verification.md
    ├── 02_First_Member_API.md
    ├── 03_CRUD_Operations.md
    └── ...
```