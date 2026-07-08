\# Step: Frontend Family Management



Date: 08.07.2026



\## Goal



Connect the React frontend with the Spring Boot backend.



\## Implemented



\- Created React frontend with Vite

\- Added component structure:

&#x20; - components

&#x20; - pages

\- Added FamilyManagement page

\- Added REST communication using fetch API



\## API Connection



Frontend:



http://localhost:5173 / 5174





Backend:



http://localhost:8080





Endpoint:



GET /families



POST /families





\## Result



Family can be created in the GUI.



Example:



MyFirstFam





The created family is stored in PostgreSQL and displayed again after loading.



\## Architecture



React

&#x20;|

&#x20;REST

&#x20;|

&#x20;Spring Boot

&#x20;|

&#x20;JPA

&#x20;|

&#x20;PostgreSQL

