# 04 – CRUD Operations

## Ziel

Nach der Implementierung der Entity, des Repositorys, des Service und des REST-Controllers wurden alle grundlegenden CRUD-Operationen (Create, Read, Update, Delete) erfolgreich implementiert und getestet.

---

## Implementierte Endpunkte

| HTTP-Methode | Endpunkt | Beschreibung |
|--------------|-----------|--------------|
| GET | /members | Gibt alle Mitglieder zurück |
| GET | /members/{id} | Gibt ein einzelnes Mitglied anhand der ID zurück |
| POST | /members | Erstellt ein neues Mitglied |
| PUT | /members/{id} | Aktualisiert ein vorhandenes Mitglied |
| DELETE | /members/{id} | Löscht ein Mitglied |

---

## Test 1 – GET /members/{id}

### Anfrage

```text
GET http://localhost:8080/members/1
```

### Erwartetes Ergebnis

```json
{
  "id": 1,
  "name": "Max Mustermann",
  "email": "max@example.com"
}
```

### Ergebnis

Der Endpunkt liefert das gewünschte Mitglied anhand seiner ID zurück.

---

## Test 2 – PUT /members/{id}

### Anfrage

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

### Ergebnis

```text
id    : 1
name  : Max Mueller
email : max.mueller@example.com
```

### Datenbankprüfung

Anschließend wurde die Tabelle erneut geprüft.

```sql
SELECT * FROM members;
```

Die aktualisierten Werte wurden korrekt übernommen.

---

## Test 3 – DELETE /members/{id}

### Anfrage

```powershell
Invoke-RestMethod `
    -Uri "http://localhost:8080/members/1" `
    -Method DELETE
```

Der DELETE-Endpunkt liefert bei erfolgreicher Ausführung keine Ausgabe zurück (HTTP Status 204).

---

## Test 4 – Kontrolle über REST-API

Nach dem Löschen wurde erneut geprüft:

```text
GET http://localhost:8080/members
```

Ergebnis:

```json
[]
```

Es befinden sich keine Datensätze mehr in der Datenbank.

---

## Test 5 – Kontrolle in PostgreSQL

Zur Überprüfung wurde die Datenbank direkt abgefragt.

```sql
SELECT * FROM members;
```

Ergebnis:

```text
0 rows
```

Die Datenbank enthält nach dem DELETE-Vorgang keine Datensätze mehr.

---

## Screenshots

Die folgenden Screenshots wurden erstellt und separat dokumentiert:

- GET /members/{id}
- PUT /members/{id}
- DELETE /members/{id}
- Ausgabe von GET /members nach dem Löschen
- SQL-Abfrage in pgAdmin
- Tabelle nach erfolgreichem DELETE

---

## Fazit

Mit diesem Schritt wurde die vollständige CRUD-Funktionalität des Member-Moduls umgesetzt.

Die REST-Schnittstelle kommuniziert erfolgreich mit PostgreSQL über Spring Data JPA. Alle vier grundlegenden Datenbankoperationen (Create, Read, Update und Delete) konnten erfolgreich getestet und verifiziert werden.

Damit steht eine vollständige Backend-Grundlage für die weitere Entwicklung der FamilyFlow-Anwendung zur Verfügung.