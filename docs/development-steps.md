\# FamilyFlow Development Steps



\## Step 1 - Project Setup



Created the basic project structure.



Modules:



\- backend

\- frontend

\- notification-service

\- database

\- docs





Technologies:



\- Java 21

\- Spring Boot

\- React / Vite

\- PostgreSQL

\- Maven





\---



\## Step 2 - Backend Implementation



Implemented the backend service.



Features:



\- Spring Boot REST API

\- Family management

\- Task management

\- Member management

\- PostgreSQL persistence





Implemented modules:





backend

├── family

├── task

├── member

└── config







\---



\## Step 3 - Database Integration



Connected the backend with PostgreSQL.



Implemented:



\- JPA entities

\- repositories

\- database access





The backend stores application data permanently.





\---



\## Step 4 - Frontend Development



Created the React frontend.



Implemented:



\- Dashboard

\- Family Management

\- Task Management





The GUI was designed using Google Stitch.



Documentation:





docs/google-stitch-prompts.md





Screenshots:





docs/dashboard.png

docs/tasks.png

docs/familymgmt.png







\---



\## Step 5 - Distributed Service Implementation



Implemented an independent Notification Service.



Architecture:





Backend Service

|

| REST communication

v

Notification Service







The notification service runs as a separate Spring Boot application:





Port: 8082







The backend communicates with the notification service using HTTP REST.





\---



\## Step 6 - Testing



Backend tests executed successfully:





mvn clean test





Result:





Tests run: 3

Failures: 0

Errors: 0

BUILD SUCCESS







Distributed communication was tested:



Backend:





Sending notification to service

Type: FAMILY\_CREATED

Message: Family created: DistributedTest3







Notification Service:





Notification received

Type: FAMILY\_CREATED

Message: Family created: DistributedTest3







\---



\## Step 7 - Documentation and Version Control



Added documentation:



\- Google Stitch prompts

\- UI screenshots

\- Distributed architecture description

\- Start guide

\- Development steps





All changes are tracked using Git and pushed to GitHub.

