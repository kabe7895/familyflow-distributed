# Task Module

## Purpose

The Task module provides a task management system for FamilyFlow.

Users can create, read and delete tasks.
Tasks can be marked as completed.

The module supports the idea of a family organizer / personal ToDo manager.


## Architecture

The module follows a layered Spring Boot architecture:

Controller
- Provides REST API endpoints

Service
- Contains application logic

Repository
- Handles database communication

Entity
- Represents the database model


## Database Entity

Table:

tasks


Fields:

| Field | Type |
|---|---|
| id | Long |
| title | String |
| description | String |
| completed | Boolean |


## REST API


### Get all tasks

GET

/tasks


Returns all available tasks.


### Get task by id

GET

/tasks/{id}


### Create task

POST

/tasks


Example:

{
"title":"Buy groceries",
"description":"Milk and bread"
}


### Update task

PUT

/tasks/{id}


Changes task information.


### Delete task

DELETE

/tasks/{id}


## Testing

The module was tested successfully using:

mvn test


Result:

BUILD SUCCESS