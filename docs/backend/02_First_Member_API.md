# First Member API

## Purpose

This document verifies the first implemented REST API functionality of the FamilyFlow backend.

The Member API demonstrates the complete flow:

```text
Client
  |
  | HTTP REST Request
  |
  v
MemberController
  |
  v
MemberService
  |
  v
MemberRepository
  |
  v
PostgreSQL Database
```

Implemented components:

- Member Entity
- MemberRepository
- MemberService
- MemberController


---

# REST Endpoints

The Member module provides REST endpoints for managing family members.


---

## Get all members

### HTTP Request

```http
GET /members
```

### PowerShell Test

```powershell
curl.exe http://localhost:8080/members
```

### Response

```json
[
  {
    "id": 1,
    "name": "Max Mustermann",
    "email": "max@example.com"
  }
]
```


---

## Create member

### HTTP Request

```http
POST /members
```

### Request Body

```json
{
  "name": "Max Mustermann",
  "email": "max@example.com"
}
```

### PowerShell Test

```powershell
Invoke-RestMethod ...
```

### Response

```json
{
  "id": 1,
  "name": "Max Mustermann",
  "email": "max@example.com"
}
```


---

# Verification

The successful API test confirms that:

- The REST controller receives requests correctly
- The service layer processes the operation
- The repository communicates with PostgreSQL
- Member data is persisted and returned correctly


---

# Conclusion

The first FamilyFlow REST API endpoint was successfully implemented and tested.

The Member module provides the foundation for further backend development, including additional domain modules such as Family and Task.