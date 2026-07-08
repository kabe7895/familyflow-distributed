# 05 – Input Validation

## Ziel

Nach der erfolgreichen Implementierung der CRUD-Funktionalität wurde die Eingabevalidierung für das Member-Modul ergänzt.

Ziel der Validierung ist es, ungültige Daten bereits vor dem Speichern in der Datenbank abzufangen.

Beispiele:

- Name darf nicht leer sein.
- E-Mail darf nicht leer sein.
- E-Mail muss ein gültiges Format besitzen.

---

## Implementierung

Die Validierung wurde direkt in der Entity `Member` umgesetzt.

Verwendete Annotationen:

| Annotation | Beschreibung |
|------------|--------------|
| `@NotBlank` | Verhindert leere oder nur aus Leerzeichen bestehende Eingaben |
| `@Email` | Prüft das Format einer E-Mail-Adresse |
| `@Valid` | Aktiviert die Validierung im REST-Controller |

---

## Angepasste Entity

Die Attribute `name` und `email` wurden mit Validierungsregeln erweitert.

Beispiel:

```java
@NotBlank(message = "Name must not be empty")
private String name;

@NotBlank(message = "Email must not be empty")
@Email(message = "Invalid email address")
private String email;
```

---

## Angepasster REST-Controller

Die Validierung wird durch `@Valid` im Controller aktiviert.

Beispiel:

```java
@PostMapping
public Member createMember(@Valid @RequestBody Member member) {
    return service.createMember(member);
}
```

Dadurch überprüft Spring Boot automatisch die Eingabedaten vor dem Speichern.

---

# Test 1 – Erfolgreiche Validierung mit gültigen Daten

## Request

Ein neues Member-Objekt wurde mit gültigen Daten erstellt.

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

## Ergebnis

```text
id name email
-- ---- -----
2  Anna anna@example.com
```

Der Datensatz wurde erfolgreich gespeichert.

---

## Kontrolle über REST API

Anschließend wurde die Member-Liste abgefragt:

```powershell
curl.exe http://localhost:8080/members
```

Ergebnis:

```json
[
  {
    "id":2,
    "name":"Anna",
    "email":"anna@example.com"
  }
]
```

Der Datensatz ist vorhanden und wurde erfolgreich in PostgreSQL gespeichert.

---

# Test 2 – Ablehnung ungültiger Daten

## Request

Es wurde absichtlich ein ungültiger Datensatz gesendet:

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

## Ergebnis

Der Server antwortete mit:

```text
HTTP 400 Bad Request
```

Der Datensatz wurde nicht gespeichert.

---

## Datenbankprüfung

Die Datenbank wurde anschließend über pgAdmin geprüft.

SQL-Abfrage:

```sql
SELECT * FROM members;
```

Ergebnis:

Der ungültige Datensatz wurde nicht in die Datenbank geschrieben.

---

# Screenshots

Folgende Screenshots wurden separat dokumentiert:

- Erfolgreicher POST-Request mit gültigen Daten
- GET `/members` mit gespeichertem Member
- Fehlerhafter POST-Request mit HTTP 400
- Datenbankprüfung in pgAdmin

---

# Fazit

Die Eingabevalidierung für das Member-Modul wurde erfolgreich umgesetzt.

Die Anwendung kann nun:

- gültige Daten akzeptieren und speichern
- ungültige Eingaben erkennen
- fehlerhafte Datensätze vor dem Speichern blockieren

Damit wurde die Qualität und Sicherheit der REST-API verbessert.