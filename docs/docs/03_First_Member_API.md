# First Member API

## Implemented Components

- Member Entity
- MemberRepository
- MemberService
- MemberController

## REST Endpoints

### GET all members

HTTP Request:

GET /members

PowerShell test:

curl.exe http://localhost:8080/members

Response:

[
  {
    "id": 1,
    "name": "Max Mustermann",
    "email": "max@example.com"
  }
]

---

### Create member

HTTP Request:

POST /members

Request body:

{
  "name": "Max Mustermann",
  "email": "max@example.com"
}

PowerShell test:

Invoke-RestMethod ...

Response:

{
  "id": 1,
  "name": "Max Mustermann",
  "email": "max@example.com"
}
