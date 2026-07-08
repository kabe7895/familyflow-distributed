# DTO Layer Implementation

## Ziel

Die API wurde von direkter Verwendung der Datenbank-Entity auf eine getrennte DTO-Schicht umgestellt.

Dadurch werden Datenbankmodell und API-Modell voneinander getrennt.

Die Struktur ist nun:


Client
|
v
Controller
|
v
Request DTO
|
v
Service
|
v
Entity
|
v
PostgreSQL


Für Antworten wird die Entity wieder in ein Response DTO umgewandelt.

---

# Umsetzung

## MemberRequestDTO

Datei:


member/dto/MemberRequestDTO.java


Verwendung:

- Aufnahme von API-Eingaben
- Validierung der Request-Daten
- Keine direkte Übergabe der Entity an den Client

Beispiel Request:

```json
{
  "name": "Peter",
  "email": "peter@example.com"
}
MemberResponseDTO

Datei:

member/dto/MemberResponseDTO.java

Verwendung:

Ausgabe von Member-Daten über die REST API
Kontrollierte Rückgabe von Feldern

Beispiel Response:

{
  "id": 3,
  "name": "Peter",
  "email": "peter@example.com"
}
Anpassungen
MemberController

Vorher:

@RequestBody Member member

Nachher:

@RequestBody MemberRequestDTO member

Der Controller arbeitet jetzt ausschließlich mit DTOs.

MemberService

Der Service übernimmt die Umwandlung:

Entity → Response DTO

Beispiel:

new MemberResponseDTO(
    member.getId(),
    member.getName(),
    member.getEmail()
);

Beim Erstellen eines Members wird aus dem Request DTO eine Entity erzeugt.

API Test
GET Members

Befehl:

curl.exe http://localhost:8080/members

Ergebnis:

[
 {
   "id":2,
   "name":"Anna",
   "email":"anna@example.com"
 }
]
POST Member

Request:

$body = @{
    name = "Peter"
    email = "peter@example.com"
} | ConvertTo-Json

Ausführung:

Invoke-RestMethod `
    -Uri "http://localhost:8080/members" `
    -Method POST `
    -ContentType "application/json" `
    -Body $body

Ergebnis:

id name  email
-- ----  -----
3  Peter peter@example.com
Ergebnis

Die REST API verwendet nun eine saubere Schichtenarchitektur:

Entity Layer
Repository Layer
Service Layer
DTO Layer
Controller Layer