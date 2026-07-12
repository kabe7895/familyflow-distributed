# Member Module

## Overview

The **Member module** manages family members within the **FamilyFlow** application.

A member represents a person belonging to a family.

The module provides the following functionality:

- Create family members
- Retrieve family members
- Update member data
- Delete family members


---

# Backend Structure

The Member module follows the **layered Spring Boot architecture**.

The implementation is separated into different responsibility layers:

```text
member
│
├── Member.java
├── MemberRepository.java
├── MemberService.java
└── MemberController.java

dto
│
├── MemberRequestDTO.java
└── MemberResponseDTO.java
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

A family member contains the following attributes:

| Attribute | Description |
|---|---|
| `id` | Unique identifier |
| `name` | Name of the family member |
| `email` | Email address of the member |

The entity is persisted in **PostgreSQL** using:

- Spring Data JPA
- Hibernate ORM


---

# REST API

The Member module exposes the following REST endpoints.


## Get all members

### Request

```http
GET /members
```

### Description

Returns all stored family members.


---

## Get member by ID

### Request

```http
GET /members/{id}
```

### Description

Returns a single member identified by its unique ID.


---

## Create member

### Request

```http
POST /members
```

### Description

Creates a new family member.

### Example Request Body

```json
{
  "name": "Max Mustermann",
  "email": "max@example.com"
}
```


---

## Update member

### Request

```http
PUT /members/{id}
```

### Description

Updates an existing family member.


---

## Delete member

### Request

```http
DELETE /members/{id}
```

### Description

Deletes a member from the database.


---

# Architecture Flow

A request is processed through the following application layers:

```text
Client
  |
  | HTTP REST Request
  |
  v
Controller
  |
  v
Service
  |
  v
Repository
  |
  v
PostgreSQL Database
```


The separation of responsibilities improves:

- maintainability
- testability
- scalability


---

# Testing

Implemented tests include:

- Creating a member
- Retrieving all members
- Retrieving a member by ID
- Handling unknown member IDs


The tests verify the correct interaction between:

- Controller layer
- Service layer
- Repository layer
- Database layer


---

# Documentation Structure

Current documentation structure:

```text
docs
│
├── 01_Project_Setup.md
├── 02_Project_Architecture.md
├── 03_Member_Module.md
├── 06_Development_Steps.md
├── 07_CLI_Tools.md
│
└── backend
    │
    ├── 01_Database_Verification.md
    └── ...
```