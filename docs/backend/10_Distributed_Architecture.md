# FamilyFlow Distributed Architecture

## Overview

FamilyFlow is implemented as a distributed application consisting of multiple independent processes.

The system contains:

- React Frontend
- Backend Service
- Notification Service
- PostgreSQL Database


## Architecture


Frontend (React)
|
| REST API
v
Backend Service
Port: 8080

  |
  | HTTP REST Communication
  v

Notification Service
Port: 8082



## Backend Service

Responsibility:

- Manage families
- Store family data
- Provide REST endpoints
- Communicate with external services


Technology:

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL


## Notification Service

Responsibility:

- Receive notification events
- Process notifications independently from the backend


Technology:

- Java 21
- Spring Boot


## Distributed Communication Example

When a new family is created:

1. User creates a family in the frontend.
2. Backend stores the family in PostgreSQL.
3. Backend sends an HTTP POST request to the Notification Service.
4. Notification Service receives and processes the event.


Example event:


Type:
FAMILY_CREATED

Message:
Family created: DistributedTest3



## Proof of Execution

Backend log:


Sending notification to service
Type: FAMILY_CREATED
Message: Family created: DistributedTest3
Notification sent



Notification Service log:


Notification received
Type: FAMILY_CREATED
Message: Family created: DistributedTest3



## Conclusion

The application fulfills the distributed software requirement because multiple independent processes communicate with each other to complete tasks.