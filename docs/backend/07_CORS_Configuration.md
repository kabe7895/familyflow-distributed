# CORS Configuration

## Purpose

The FamilyFlow backend API was prepared for future frontend and Android applications.

To allow communication between different applications running on different origins, a global Spring Boot CORS configuration was implemented.

CORS (**Cross-Origin Resource Sharing**) controls which external clients are allowed to access the REST API.


---

# Implementation

A global CORS configuration class was created:

```text
config/

└── CorsConfig.java
```

The configuration allows cross-origin requests for the REST API.


Supported HTTP methods:

- GET
- POST
- PUT
- DELETE


The configuration prepares the backend for communication with:

- React frontend applications
- Android mobile applications
- Other external API clients


---

# Test

The backend was started using Maven:

```bash
mvn spring-boot:run
```

The REST API remained accessible after adding the CORS configuration.


## API Test

Request:

```http
GET http://localhost:8080/members
```

Response:

```json
[
  {
    "id": 2,
    "name": "Anna",
    "email": "anna@example.com"
  }
]
```


The API continues to return data successfully.


---

# Status

CORS preparation was successfully completed.

The backend is now prepared for communication with external frontend and mobile clients.