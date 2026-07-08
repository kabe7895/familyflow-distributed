# 06 – Exception Handling

## Ziel

Nach der Implementierung der CRUD-Funktionalität wurde ein eigenes Exception Handling für die Member-API eingeführt.

Ziel ist es, Fehler nicht mehr mit den Standard-Spring-Fehlermeldungen zurückzugeben, sondern eine einheitliche und verständliche API-Antwort bereitzustellen.

---

## Problem vorher

Bei nicht vorhandenen Membern wurde eine allgemeine RuntimeException verwendet.

Beispiel:

```java
throw new RuntimeException("Member not found");
```

Diese Lösung ist funktional, aber nicht optimal, da:

- keine eindeutige Fehlerklasse vorhanden ist
- Fehlerbehandlung nicht zentral erfolgt
- API-Clients keine einheitliche Antwort erhalten

---

# Implementierung

## 1. Eigene Exception

Es wurde eine eigene Exception erstellt:

```text
exception/
└── MemberNotFoundException.java
```

Diese Exception wird ausgelöst, wenn ein Member mit einer bestimmten ID nicht gefunden wird.

Beispiel:

```java
public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(Long id) {
        super("Member with id " + id + " not found");
    }
}
```

---

## 2. Anpassung im Service

Die vorherige RuntimeException wurde ersetzt.

Vorher:

```java
.orElseThrow(() -> new RuntimeException("Member not found"));
```

Nachher:

```java
.orElseThrow(() -> new MemberNotFoundException(id));
```

Dadurch wird ein klar definierter Fehler ausgelöst.

---

## 3. Global Exception Handler

Eine zentrale Fehlerbehandlung wurde implementiert:

```text
exception/
└── GlobalExceptionHandler.java
```

Der Handler fängt `MemberNotFoundException` ab und erzeugt eine standardisierte JSON-Antwort.

Beispiel:

```json
{
    "timestamp": "2026-07-08T07:25:35",
    "status": 404,
    "message": "Member with id 999 not found"
}
```

---

# Test 1 – Vorhandener Member

## Request

```powershell
curl.exe http://localhost:8080/members/2
```

## Ergebnis

```json
{
  "id":2,
  "name":"Anna",
  "email":"anna@example.com"
}
```

Der Member wurde erfolgreich gefunden.

---

# Test 2 – Nicht vorhandener Member

## Request

```powershell
curl.exe http://localhost:8080/members/999
```

## Ergebnis

```json
{
  "timestamp":"2026-07-08T07:25:35.6792555",
  "status":404,
  "message":"Member with id 999 not found"
}
```

Die API liefert nun eine kontrollierte HTTP-404-Antwort.

---

# Screenshots

Dokumentierte Screenshots:

- Erfolgreicher GET-Aufruf eines vorhandenen Members
- Fehlerantwort bei nicht vorhandener Member-ID
- Ausgabe aus PowerShell

---

# Fazit

Das Backend besitzt nun eine zentrale Fehlerbehandlung.

Vorteile:

- klare Fehlerstruktur
- bessere Wartbarkeit
- verständliche API-Antworten
- bessere Vorbereitung für zukünftige Clients wie die Android-App

Die Member-API besitzt damit neben CRUD-Funktionalität auch eine professionelle Fehlerbehandlung.