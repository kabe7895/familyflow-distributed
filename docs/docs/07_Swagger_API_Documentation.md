# Swagger API Documentation

## Overview

Swagger UI was added to the FamilyFlow backend using Springdoc OpenAPI.

The Swagger interface provides an interactive documentation and testing environment for all available REST endpoints.

The documentation is automatically generated from the Spring Boot controllers.

---

## Configuration

Swagger was integrated by adding the following Maven dependency:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.9</version>
</dependency>

Swagger UI

The Swagger interface is available at:

http://localhost:8080/swagger-ui/index.html

The OpenAPI specification is available at:

http://localhost:8080/v3/api-docs
Available API Endpoints
Member Controller

The following endpoints are documented:

Method	Endpoint	Description
GET	/members	Retrieve all members
POST	/members	Create a new member
GET	/members/{id}	Retrieve a member by ID
PUT	/members/{id}	Update an existing member
DELETE	/members/{id}	Delete a member
Health Controller
Method	Endpoint	Description
GET	/health	Check backend availability
Testing

The Swagger UI allows testing all REST endpoints directly from the browser.

Example:

POST /members

Request body:

{
  "name": "Anna",
  "email": "anna@example.com"
}

The API returns the created member including the generated database ID.