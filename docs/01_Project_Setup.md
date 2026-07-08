# Project Setup

## Ziel

FamilyFlow wird als verteilte Anwendung entwickelt.

Komponenten:

- Spring Boot Backend
- Android App
- PostgreSQL Datenbank
- OpenAI Integration

Die Entwicklung erfolgt schrittweise und wird vollständig dokumentiert.

# FamilyFlow - Project Overview

## Idea

FamilyFlow is a distributed family management application.

The goal is to provide a central platform where families can manage:

- family members
- tasks
- organization data


## Technologies

Backend:
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL


Frontend:
- React
- Vite


Development Tools:
- Visual Studio Code
- Git CLI


## Architecture

The application follows a modular architecture.

Backend modules:

- Member Module
- Family Module
- Task Module


Each module contains:

- Entity
- Repository
- Service
- Controller
- DTOs
02_member_module.md
# Member Module

## Goal

The Member module manages family members.

A member contains:

- id
- name
- email


## Backend Structure


member

Member.java
MemberRepository.java
MemberService.java
MemberController.java

dto

MemberRequestDTO
MemberResponseDTO


## REST API

### Get all members

GET


/members



### Get member by id

GET


/members/{id}



### Create member

POST


/members



### Update member

PUT


/members/{id}



### Delete member

DELETE


/members/{id}



## Testing

Implemented tests:

- create member
- get all members
- return 404 for unknown member
03_family_module.md
# Family Module


## Goal

The Family module manages families.


## Backend Structure


family

Family.java
FamilyRepository.java
FamilyService.java
FamilyController.java

dto

FamilyRequestDTO
FamilyResponseDTO


## REST API

GET


/families



GET


/families/{id}



POST


/families



PUT


/families/{id}



DELETE


/families/{id}



## Database

Table:

families


Fields:

- id
- familyName
- createdAt
04_task_module.md

(das schreiben wir jetzt schon, auch bevor der Code fertig ist)

# Task Module


## Goal

The Task module provides task management functionality.

Families can organize tasks and track completion status.


## Backend Structure


task

Task.java
TaskRepository.java
TaskService.java
TaskController.java

dto

TaskRequestDTO.java
TaskResponseDTO.java



## Entity

A task contains:

- id
- title
- description
- completed


## REST API

GET


/tasks



GET


/tasks/{id}



POST


/tasks



PUT


/tasks/{id}



DELETE


/tasks/{id}



## Development Status

Implementation in progress.
05_architecture.md
# Architecture


## Overview

FamilyFlow is a distributed application consisting of:

- Frontend client
- Backend REST API
- PostgreSQL database


## Communication

Frontend communicates with backend using HTTP REST API.


## Backend Layers


Controller Layer

Responsible for HTTP requests.


Service Layer

Contains business logic.


Repository Layer

Handles database communication.


Entity Layer

Represents database tables.
06_google_stitch_design.md

Das brauchen wir später für die Punkte:

# Google Stitch Design


## Purpose

The frontend design was created using Google Stitch.


## Prompt

Create a modern family management application called FamilyFlow.

The application should contain:

- dashboard
- family members
- tasks
- calendar
- user profile

Design requirements:

- modern SaaS style
- responsive layout
- clean cards
- sidebar navigation
- family friendly colors


## Screens

Screenshots will be added:

- Dashboard
- Members page
- Tasks page
07_development_steps.md
# Development Steps


## Step 1

Project initialization.

Created Spring Boot backend.


## Step 2

Implemented Member module.

Result:

- CRUD operations
- database integration
- tests


## Step 3

Implemented Family module.

Result:

- CRUD operations
- database integration


## Step 4

Implemented Task module.

Result:

- task management API


## Step 5

Create frontend with React and Google Stitch design.