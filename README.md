# Java Open Source Project

## Resources

- POM Multimodule: https://www.mkyong.com/maven/maven-how-to-create-a-multi-module-project/
- Spring Initializr: https://start.spring.io/


## Schwierigkeiten im Projekt

### Teamwork

Die erste Schwierigkeit in diesem Projekt war die Rollenverteilung. Wer macht was, wie machen wir es etc. Wir haben uns dann entschieden, dass jeweils eine Aufgabe von einer Person gemacht wird. Anfangs hat das gut funktioniert, doch dann hat ein Gruppenmitglied nicht mehr das gemacht was er eigentlich gesagt hat oder zu spät und es wurde schon von den anderen beiden erledigt. Diese Person hat danach die Gruppe verlassen, da wir gesagt haben, wir werden ihn nicht mittragen solange er nichts macht.

### Projekt

Eine weitere Schwierigkeit war es das Projekt richtig aufzubauen. Zuerst war die Projektstruktur nicht gut aufgebaut und somit hat Maven und Spring Boot nicht funktionieren wollen. Zusätzlich gab es Probleme mit der IDE, vorallem mit Eclipse. Daher haben wir uns entschieden Tabula Rasa zu machen und alles nochmal anhand der oben erwähnten Quelle aufzubauen.

Während dem entwickeln hatten wir ein wenig Mühe, das ganze zu verstehen und auch korrekt zumzusetzen. Zum Teil haben im
Skript auch wichtige Informationen gefehlt, die dann entweder durch Googeln oder durch Betrachten der Lösungen ermittelt
werden mussten. Vaadin hat auch einige Schwierigkeiten bereitet, vorallem mit der Request und der Anpassung der battle Methode. Die Seite localhost:4444/promoter/promoteFight macht seit der Einführung von Eureka Probleme mit der Darstellung.


## Lösungen/Workarounds

Der Battle Algorithmus ist langsam aufgrund der vielen Log Calls, dies führt in zuul oft zu einem Histrix Timeout, leider haben wir nicht herausgefunden wie man das Timeout höher setzt, darum haben wir das Logging optimiert sodass nur ein `LOG.info` call nötig ist (der ganze Verlauf wird trotzdem geloggt). Die Erfolgsrate von `localhost:8080/promoter/promoter/promoteFight` ist nun bei 90% (statt vorher 30%).

Das implementieren von Vaadin war gegen Schluss ein Try and Error. Bei jeder Änderung von Requests musste man schauen, dass die Ports stimmen, der Request den richtigen Wert übergiebt und vieles mehr. Zurzeit ist es so, dass der Promoter als letztes gestartet werden darf, da sonst die Applikation eine Exception wirft. 

## Erweiterungen

### Vaadin

Damit die Darstellung der Heroes auch adrett aussieht, haben wir uns entschieden Vaadin für das UI zu verwenden. Für dies haben wir das POM mit der Dependency für Vaadin erweitert. Danach war die Überlegung, was wir genau darstellen wollen. Die entscheidung fiel auf die Camp und Promoter Applikation. 

Für das Camp wurde eine eigene Seite generiert (localhost:2222/home). Diese beinhaltet ein Grid das alle Heroes darstellt, die erstellt wurden. Wenn die Seite aufgerufen wird, ohne dass der Promoter Service einen Fight gehostet hat, werden alle Heroes in keiner Party sein. Die ändert sich, wenn der Promoter Service verwendet wird. Nachdem die Heroes einer Party zugewiesen worden sind, wird die Spalte aktualisiert und der Name angezeigt. Um dies zu erreichen wurde der Camp Applikation eine neue Klasse hinzugefügt, die die View darstellt. Der Konsturktor dieser Klasse generiert das Grid und bindet die Hero Klasse an das Grid, damit man mit der Methode grid.setColumns("name", "atk", "def"); nur die Felder von der Hero Klasse nehmen kann und Vaadin bindet die entsprechenden Werte zusammen. Mit der Annotation @Route(value = "home") kann man bestimmten, wo der Entrypoint ist für die View.

Für den Promoter (localhost:4444/promoter/promoteFight) wurde nicht nur das UI implementiert, sondern auch die funktionsweise der Arena und der battle Methode verändert. Die battle Methode hat nur einen String mit der Gewinnerparty zurück gegeben und nur mit diesem konnten wir schlecht arbeiten. Deswegen hat der DefaultArenaService in der Arena ein neuer Rückgabewert erhalten und zwar eine Liste von den Parties, die gekämpft haben. Zusätzlich hat die Party ein neues Feld "isWinner" erhalten. Somit konnte die Verarbeitung der Daten besser gestaltet werden. Der DefaultPromoterService hat auch ein Upgrade bekommen, dieser gibt den Heroes verschiedene Partynamen und schaut, dass im gleichen Kampf nicht derselbe Name existiert. Die View zeigt den Gewinner und die Helden der Gewinnerparty, in einem zweitem Grid werden alle Heroes aufgelistet, die beim Kampf die HP auf 0 hatten. Das letzte Grid zeigt noch die Heroes von der Verliererparty an. 

### Name Service

Der Name Service erlaubt es Heldennamen zufällig zu generieren, dabei werden aus einem Satz aus Vor- und Nachnamen zufällige Namen ausgewählt und kombiniert. Damit werden zum Beispiel die folgenden lustigen Namenskombinationen generiert:

- Captain Heisenberg
- Dr. White
- Commander Freeman
- Dr. Snow
- Captain Winter
- Balthasar Stark
- Vreni Picard
- Balthasar White
- Housi Nimmerlich
- Jordan Winter

## Jetziger Stand

Das Projekt läuft nun und hat sogar ein Web Frontend dank Vaadin. Leider ist es noch keine fixfertige Vorlage für ein
Microservices Projekt, da das Problem mit den Hystrix Timeouts beim besten Willen und auch nach langem Recherchieren nicht
gelöst werden konnte (für produktive Applikationen wäre es fatal wenn man die Timeouts nicht selbst setzen kann). Durch
den Workaround mit den reduzierten Log Calls konnte das Problem zumindest im Rahmen dieses Projekts behoben werden.

Zusätzlich könnte man Vaadin besser ausbauen und Funktionen hinzufügen, die einem erlaubt, eigene Helden zu erstellen. Dennoch ermöglicht diese Erweiterung eine Art Darstellung für den Kampf. Da wir durch das Fehlen eines Mitgliedes, Arbeit und Studium zeitlich gesehen eingeschränkt waren, konnten wir leider nicht mehr realisieren.

## Betriebsanleitung


