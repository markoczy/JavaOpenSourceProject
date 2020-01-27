# Java Open Source Project

## Resources

- POM Multimodule: https://www.mkyong.com/maven/maven-how-to-create-a-multi-module-project/

## Features

- **NameService:** Erlaubt es Heldennamen zufällig zu generieren, dabei werden aus einem
Satz aus Vor- und Nachnamen zufällige Namen ausgewählt und kombiniert.

## Schwierigkeiten

- Der Battle Algorithmus ist langsam aufgrund der vielen Log Calls, dies führt in zuul oft
zu einem Histrix Timeout, leider haben wir nicht herausgefunden wie man das Timeout höher 
setzt, darum haben wir das Logging optimiert sodass nur ein `LOG.info` call nötig ist 
(der ganze Verlauf wird trotzdem geloggt). Die Erfolgsrate von 
`localhost:8080/promoter/promoter/promoteFight` ist nun bei 90% (statt vorher 30%).