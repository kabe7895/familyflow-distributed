# CORS Configuration

## Ziel

Die Backend-API wurde für zukünftige Android- und Frontend-Anwendungen vorbereitet.

Cross-Origin Requests werden über eine globale Spring Boot CORS-Konfiguration erlaubt.

## Umsetzung

Neue Konfigurationsklasse:


config/CorsConfig.java


Die Konfiguration erlaubt:

- GET Requests
- POST Requests
- PUT Requests
- DELETE Requests

für definierte Frontend-Ursprünge.

## Test

Backend gestartet:


mvn spring-boot:run


API weiterhin erreichbar:


GET http://localhost:8080/members


Ergebnis:

```json
[
 {
   "id":2,
   "name":"Anna",
   "email":"anna@example.com"
 }
]
Status

CORS Vorbereitung erfolgreich abgeschlossen.