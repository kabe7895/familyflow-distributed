# Input Validation

## Purpose

After implementing the complete CRUD functionality, input validation was added to the Member module.

The purpose of validation is to prevent invalid data from being stored in the database.

Examples:

- Name must not be empty.
- Email must not be empty.
- Email must have a valid format.


---

# Implementation

The validation rules were implemented directly in the `Member` entity.

Used annotations:

| Annotation | Description |
|---|---|
| `@NotBlank` | Prevents empty or whitespace-only values |
| `@Email` | Validates the format of an email address |
| `@Valid` | Activates validation in the REST controller |


---

# Updated Entity

The attributes `name` and `email` were extended with validation rules.

Example:

```java
@NotBlank(message = "Name must not be empty")
private String name;

@NotBlank(message = "Email must not be empty")
@Email(message = "Invalid email address")
private String email;
```

The validation rules are checked automatically by Spring Boot before persisting the entity.


---

# Updated REST Controller

Validation is activated using `@Valid` in the REST controller.

Example:

```java
@PostMapping
public Member createMember(@Valid @RequestBody Member member) {
    return service.createMember(member);
}
```

Spring Boot automatically validates the incoming request data before saving it to the database.


---

# Test 1 – Successful Validation with Valid Data

## Request

A new member object was created with valid data.

PowerShell test:

```powershell
$body = @{
    name = "Anna"
    email = "anna@example.com"
} | ConvertTo-Json

Invoke-RestMethod `
    -Uri "http://localhost:8080/members" `
    -Method POST `
    -ContentType "application/json" `
    -Body $body
```

## Result

```text
id name email
-- ---- -----
2  Anna anna@example.com
```

The member was successfully stored.


---

## REST API Verification

Afterwards, the member list was requested:

```powershell
curl.exe http://localhost:8080/members
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

The member exists and was successfully persisted in PostgreSQL.


---

# Test 2 – Rejecting Invalid Data

## Request

An invalid member object was intentionally sent:

```powershell
$body = @{
    name = ""
    email = "abc"
} | ConvertTo-Json

Invoke-RestMethod `
    -Uri "http://localhost:8080/members" `
    -Method POST `
    -ContentType "application/json" `
    -Body $body
```

## Result

The server returned:

```text
HTTP 400 Bad Request
```

The invalid member was not stored.


---

# Database Verification

The database was checked afterwards using pgAdmin.

SQL query:

```sql
SELECT * FROM members;
```

Result:

The invalid record was not inserted into the database.


---

# Screenshots

The following screenshots were documented separately:

- Successful POST request with valid data
- GET `/members` with stored member
- Failed POST request with HTTP 400
- Database verification in pgAdmin


---

# Conclusion

Input validation for the Member module was successfully implemented.

The application can now:

- Accept and store valid data
- Detect invalid input
- Prevent incorrect records from being stored


This improves the quality and security of the REST API.