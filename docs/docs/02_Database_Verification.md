# Database Verification

## Purpose

This document verifies that the FamilyFlow backend successfully stores data in PostgreSQL.

The verification confirms the complete data flow:

REST API → Spring Boot Backend → JPA/Hibernate → PostgreSQL Database

---

## 1. PostgreSQL Database Connection

The PostgreSQL database used by the backend is:

- Database: `familyflow`
- Database user: `postgres`
- PostgreSQL version: `18.4`

The database connection was configured in the Spring Boot application.

The backend successfully established a connection:


HikariPool-1 - Added connection org.postgresql.jdbc.PgConnection


---

## 2. Verify Database Using psql

PostgreSQL command line client was started:

```powershell
& "C:\Program Files\PostgreSQL\18\bin\psql.exe" -U postgres -d familyflow

After successful login, the database tables were checked.

List tables:

\dt

Expected result:

          List of relations
 Schema |   Name   | Type  | Owner
--------+----------+-------+---------
 public | members  | table | postgres
3. Check Stored Data

The content of the members table was verified:

SELECT * FROM members;

Result:

 id |      name       |       email
----+-----------------+-------------------
  1 | Max Mustermann  | max@example.com

The result confirms that the member created through the REST API was persisted in PostgreSQL.

4. Verification Using pgAdmin

The same verification was performed using pgAdmin.

Navigation:

Servers
 └── PostgreSQL 18
      └── Databases
           └── familyflow
                └── Schemas
                     └── public
                          └── Tables
                               └── members

The table members contains the inserted record.

5. REST API Test

The member was created through the backend API:

Request:

POST http://localhost:8080/members

Body:

{
  "name": "Max Mustermann",
  "email": "max@example.com"
}

Response:

{
  "id": 1,
  "name": "Max Mustermann",
  "email": "max@example.com"
}

Reading all members:

GET http://localhost:8080/members

Response:

[
  {
    "id": 1,
    "name": "Max Mustermann",
    "email": "max@example.com"
  }
]
Conclusion

The database integration was successfully verified.

The FamilyFlow backend can:

connect to PostgreSQL
create database tables using Hibernate
persist entities
retrieve stored data through REST endpoints

The first complete backend persistence workflow is operational.