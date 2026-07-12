# CRUD Operations

## Purpose

This document verifies the complete CRUD functionality of the FamilyFlow Member module.

After implementing:

- Entity
- Repository
- Service
- REST Controller

all basic database operations were implemented and tested:

- Create
- Read
- Update
- Delete


---

# Implemented REST Endpoints

| HTTP Method | Endpoint | Description |
|---|---|---|
| `GET` | `/members` | Returns all members |
| `GET` | `/members/{id}` | Returns a single member by ID |
| `POST` | `/members` | Creates a new member |
| `PUT` | `/members/{id}` | Updates an existing member |
| `DELETE` | `/members/{id}` | Deletes a member |


---

# Test 1 – Get Member by ID

## Request

```http
GET http://localhost:8080/members/1
```

## Expected Response

```json
{
  "id": 1,
  "name": "Max Mustermann",
  "email": "max@example.com"
}
```

## Result

The endpoint successfully returns the requested member by its ID.


---

# Test 2 – Update Member

## Request

PowerShell test:

```powershell
$body = @{
    name = "Max Mueller"
    email = "max.mueller@example.com"
} | ConvertTo-Json

Invoke-RestMethod `
    -Uri "http://localhost:8080/members/1" `
    -Method PUT `
    -ContentType "application/json" `
    -Body $body
```

## Response

```text
id    : 1
name  : Max Mueller
email : max.mueller@example.com
```

## Database Verification

The database content was checked afterwards:

```sql
SELECT * FROM members;
```

The updated values were stored correctly.


---

# Test 3 – Delete Member

## Request

```powershell
Invoke-RestMethod `
    -Uri "http://localhost:8080/members/1" `
    -Method DELETE
```

## Result

The DELETE endpoint successfully removes the member.

The response contains no body:

```text
HTTP Status: 204 No Content
```


---

# Test 4 – Verify REST API After Delete

After deletion, the member list was requested again:

```http
GET http://localhost:8080/members
```

## Response

```json
[]
```

No members are stored anymore.


---

# Test 5 – Verify Database After Delete

The PostgreSQL database was checked directly:

```sql
SELECT * FROM members;
```

## Result

```text
0 rows
```

The database contains no remaining member records.


---

# Screenshots

The following screenshots were created and documented separately:

- GET `/members/{id}`
- PUT `/members/{id}`
- DELETE `/members/{id}`
- GET `/members` after deletion
- SQL query in pgAdmin
- Database table after successful DELETE


---

# Conclusion

The complete CRUD functionality of the Member module was successfully implemented and verified.

The REST API communicates correctly with PostgreSQL through Spring Data JPA.

All fundamental database operations were tested:

- Create
- Read
- Update
- Delete


The Member module provides the first complete backend functionality of the FamilyFlow application.