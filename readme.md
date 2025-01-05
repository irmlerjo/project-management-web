# Web-Based Project Management Prototype
## Task Description
Ein Unternehmen möchte eine Anwendung entwickeln, die Projektinformationen verwaltet und Zeiterfassungsdaten integriert. Ziel ist es, eine Übersicht über Projektbudgets, geleistete Stunden und die Abrechnung zu ermöglichen. Darüber hinaus sollen Rechnungsdaten erfasst und Budgets überwacht werden, um kritische Überschreitungen zu melden.

 

### Entwickeln Sie einen Prototyp und ein Konzept für ein Tool, das:
- Projektdaten (z. B. Vertragsdetails, Budgets, Dokumente) erfasst
- Eine Schnittstelle zur Zeiterfassung bietet.
- Die Möglichkeit beinhaltet, Budgets und Aufwände zu vergleichen.  
- Der Fokus liegt auf der Anforderungsanalyse, der Systemarchitektur und der Erstellung eines funktionalen Prototyps. 

#### Erfasst werden muss:
- Projektname (z.B Duva NWS)
- Auftrag zum Projekt (1:n) (Z. b. Release 01.2025/ Release 02.2025)
- Beauftragtes Budget ( z.b 100 Std)
- Abrechnungstyp (Festpreis/nach Aufwand)
- Stundensatz netto
- Liefertermin

#### Schnittstelle zur Zeiterfassung
Folgende Infos werden benötigt

- tatsächlich erfasste Stunden zum Auftrag
- Stundennachweis bei Aufträgen "nach Aufwand" (Liste der erfassten Einträge mit den Attributen Tätigkeit, Bemerkung, Stunden aus der Zeiterfassung für einen definierten Zeitraum. Üblicherweise werden Leistungen z. B. quartalsweise abgerechnet.)

#### Warnungen
- bei einem Auftrag 80% des vereinbarten Stundenbudgets des Auftrags (egal bei welchem Abrechnungstyp) verbraucht wurden und/oder
- der Liefertermin näher rückt, aber nur für Abrechnungstyp Festpreis (14 Tage vorher)

 

Das Tool soll webbasiert und ohne Plugins im Browser ablauffähig sein.

Technologien:

              Server: Java

              Client: TypeScript / Angular
## 