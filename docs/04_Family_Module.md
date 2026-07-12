# Family Module

## Overview

The **Family module** manages families within the **FamilyFlow** application.

A family represents the central organizational unit of the application.

The module provides the following functionality:

- Create families
- Retrieve families
- Update family data
- Delete families


---

# Backend Structure

The Family module follows the **layered Spring Boot architecture**.

The implementation is separated into different responsibility layers:

```text
family
│
├── Family.java
├── FamilyRepository.java
├── FamilyService.java
└── FamilyController.java

dto
│
├── FamilyRequestDTO.java
└── FamilyResponseDTO.java
```

### Layer Responsibilities

| Layer | Responsibility |
|---|---|
| Entity | Represents the database model |
| Repository | Handles database access using Spring Data JPA |
| Service | Contains business logic |
| Controller | Provides REST API endpoints |
| DTO | Transfers data between API and application layers |


---

# Entity

A family contains the following attributes:

| Attribute | Description |
|---|---|
| `id` | Unique identifier |
| `familyName` | Name of the family |
| `createdAt` | Timestamp of creation |

The entity is persisted in **PostgreSQL** using:

- Spring Data JPA
- Hibernate ORM


---

# REST API

The Family module exposes the following REST endpoints.


## Get all families

### Request

```http
GET /families
```

### Description

Returns all stored families.


---

## Get family by ID

### Request

```http
GET /families/{id}
```

### Description

Returns a single family identified by its unique ID.


---

## Create family

### Request

```http
POST /families
```

### Description

Creates a new family.


### Example Request Body

```json
{
  "familyName": "Example Family"
}
```

### After successful creation

The following process is executed:

1. The family is stored in PostgreSQL.
2. The backend creates a notification event.
3. The event is sent to the Notification Service.

### Example Event

```json
{
  "type": "FAMILY_CREATED",
  "message": "Family created: Example Family"
}
```


---

## Update family

### Request

```http
PUT /families/{id}
```

### Description

Updates an existing family.


---

## Delete family

### Request

```http
DELETE /families/{id}
```

### Description

Deletes a family from the database.


---

# Distributed Communication

The Family module communicates with the independent **Notification Service**.

The Notification Service is implemented as a separate Spring Boot application.

## Communication Flow

```text
Client
  |
  | POST /families
  |
  v
FamilyController
  |
  v
FamilyService
  |
  v
Save Family
  |
  v
PostgreSQL Database
  |
  v
NotificationClient
  |
  | HTTP REST
  |
  v
Notification Service
```

The Notification Service runs independently on:

```text
Port: 8082
```


---

# Notification Integration

The backend uses a dedicated client component:

```text
NotificationClient
```

## Responsibilities

The `NotificationClient` is responsible for:

- Creating notification requests
- Sending REST requests to the Notification Service
- Decoupling notification handling from business logic


## Example Backend Output

```text
>>> Sending notification to service

Type: FAMILY_CREATED
Message: Family created: DistributedTest3

>>> Notification sent
```


## Example Notification Service Output

```text
Notification received

Type: FAMILY_CREATED
Message: Family created: DistributedTest3
```


---

# Testing

Implemented tests include:

- Creating a family
- Retrieving all families
- Retrieving a family by ID
- Updating a family
- Deleting a family
- Verifying communication with the Notification Service


The module demonstrates the interaction between:

- REST API
- Business logic
- Database persistence
- Distributed service communication


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