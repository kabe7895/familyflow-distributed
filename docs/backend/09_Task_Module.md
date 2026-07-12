# Task Module API

## Purpose

The Task module provides task management functionality for the FamilyFlow application.

Users can:

- Create tasks
- Retrieve tasks
- Update tasks
- Delete tasks
- Mark tasks as completed


The module supports the concept of a family organizer and personal ToDo management system.


---

# Architecture

The Task module follows a layered Spring Boot architecture.

```text
Controller

    |

    v

Service

    |

    v

Repository

    |

    v

Entity

    |

    v

PostgreSQL Database
```


## Layer Responsibilities

| Layer | Responsibility |
|---|---|
| Controller | Provides REST API endpoints |
| Service | Contains application logic |
| Repository | Handles database communication |
| Entity | Represents the database model |


---

# Database Entity

Database table:

```text
tasks
```

Entity fields:

| Field | Type | Description |
|---|---|---|
| `id` | Long | Unique identifier |
| `title` | String | Task title |
| `description` | String | Detailed task description |
| `completed` | Boolean | Completion status |


---

# REST API

The Task module provides the following REST endpoints.


## Get all tasks

### Request

```http
GET /tasks
```

### Description

Returns all available tasks.


---

## Get task by ID

### Request

```http
GET /tasks/{id}
```

### Description

Returns a single task identified by its ID.


---

## Create task

### Request

```http
POST /tasks
```

### Example Request Body

```json
{
  "title": "Buy groceries",
  "description": "Milk and bread"
}
```

### Description

Creates a new task.


---

## Update task

### Request

```http
PUT /tasks/{id}
```

### Description

Updates existing task information.


---

## Delete task

### Request

```http
DELETE /tasks/{id}
```

### Description

Deletes a task from the database.


---

# Testing

The Task module was tested using Maven:

```bash
mvn test
```

Result:

```text
BUILD SUCCESS
```


---

# Conclusion

The Task module was successfully integrated into the FamilyFlow backend.

The implementation provides the foundation for task management functionality and follows the same layered architecture used by the other backend modules.