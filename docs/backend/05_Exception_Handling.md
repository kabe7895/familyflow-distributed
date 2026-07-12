# Exception Handling

## Purpose

After implementing the CRUD functionality, a custom exception handling mechanism was introduced for the Member API.

The goal is to replace default Spring error responses with a consistent and understandable API response format.


---

# Problem Before Implementation

Before introducing custom exception handling, missing members were handled using a generic `RuntimeException`.

Example:

```java
throw new RuntimeException("Member not found");
```

This solution works technically, but it has several disadvantages:

- No dedicated exception type exists
- Error handling is not centralized
- API clients do not receive a consistent response format


---

# Implementation

## 1. Custom Exception

A dedicated exception class was created:

```text
exception/

└── MemberNotFoundException.java
```

This exception is thrown when a member with a specific ID cannot be found.

Example:

```java
public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(Long id) {
        super("Member with id " + id + " not found");
    }
}
```


---

## 2. Service Layer Update

The previous generic `RuntimeException` was replaced.

Before:

```java
.orElseThrow(() -> new RuntimeException("Member not found"));
```

After:

```java
.orElseThrow(() -> new MemberNotFoundException(id));
```

This creates a clearly defined application-specific error.


---

## 3. Global Exception Handler

A centralized exception handler was implemented:

```text
exception/

└── GlobalExceptionHandler.java
```

The handler catches `MemberNotFoundException` and creates a standardized JSON response.

Example response:

```json
{
  "timestamp": "2026-07-08T07:25:35",
  "status": 404,
  "message": "Member with id 999 not found"
}
```


---

# Test 1 – Existing Member

## Request

```powershell
curl.exe http://localhost:8080/members/2
```

## Response

```json
{
  "id": 2,
  "name": "Anna",
  "email": "anna@example.com"
}
```

The member was successfully retrieved.


---

# Test 2 – Non-existing Member

## Request

```powershell
curl.exe http://localhost:8080/members/999
```

## Response

```json
{
  "timestamp": "2026-07-08T07:25:35.6792555",
  "status": 404,
  "message": "Member with id 999 not found"
}
```

The API now returns a controlled HTTP 404 response.


---

# Screenshots

The following screenshots were documented separately:

- Successful GET request for an existing member
- Error response for an unknown member ID
- PowerShell output


---

# Conclusion

The backend now contains centralized exception handling.

Advantages:

- Clear error structure
- Better maintainability
- Consistent API responses
- Better preparation for future clients such as an Android application


The Member API now provides professional error handling in addition to CRUD functionality.