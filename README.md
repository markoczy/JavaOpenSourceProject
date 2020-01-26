# Java Open Source Project

## Resources

- POM Multimodule: https://www.mkyong.com/maven/maven-how-to-create-a-multi-module-project/

## Schwierigkeiten im Projekt
Die erste Schwierigkeit in diesem Projekt war die Rollenverteilung. Wer macht was, wie machen wir es etc. Wir haben uns dann entschieden, dass jeweils eine Aufgabe von einer Person gemacht wird. Anfangs hat das gut funktioniert, doch dann hat ein Gruppenmitglied nicht mehr das gemacht was er eigentlich gesagt hat oder zu spät und es wurde schon von den anderen beiden erledigt. Diese Person hat danach die Gruppe verlassen, da wir gesagt haben, wir werden ihn nicht mittragen solange er nichts macht.

Eine weitere Schwierigkeit war es das Projekt richtig aufzubauen. Zuerst war die Projektstruktur nicht gut aufgebaut und somit hat Maven und Spring Boot nicht funktionieren wollen. Zusätzlich gab es Probleme mit der IDE, vorallem mit Eclipse. Daher haben wir uns entschieden Tabula Rasa zu machen und alles nochmal anhand der oben erwähnten Quelle aufzubauen.

Während dem entwickeln hatten wir ein wenig Mühe, das ganze zu verstehen und auch korrekt zumzusetzen. Vaadin hat auch einige Schwierigkeiten bereitet.

## Lösungen/Workarounds

## Erweiterungen
### Vaadin
Damit die Darstellung der Heroes auch adrett aussieht, haben wir uns entschieden Vaadin für das UI zu verwenden. Für dies haben wir das POM mit der Dependency für Vaadin erweitert. Danach war die Überlegung, was wir genau darstellen wollen. Die entscheidung fiel auf die Camp und Promoter Applikation. 

Für das Camp wurde eine eigene Seite generiert (localhost:8080/home). Diese beinhaltet ein Grid das alle Heroes darstellt, die erstellt wurden. Wenn die Seite aufgerufen wird, ohne dass der Promoter Service einen Fight gehostet hat, werden alle Heroes in keiner Party sein. Die ändert sich, wenn der Promoter Service verwendet wird. Nachdem die Heroes einer Party zugewiesen worden sind, wird die Spalte aktualisiert und der Name angezeigt. Um dies zu erreichen wurde der Camp Applikation eine neue Klasse hinzugefügt, die die View darstellt. Der Konsturktor dieser Klasse generiert das Grid und bindet die Hero Klasse an das Grid, damit man mit der Methode grid.setColumns("name", "atk", "def"); nur die Felder von der Hero Klasse nehmen kann und Vaadin bindet die entsprechenden Werte zusammen. Mit der Annotation @Route(value = "home") kann man bestimmten, wo der Entrypoint ist für die View.

Für den Promoter wurde nicht nur das UI implementiert, sondern auch die funktionsweise der Arena und der battle Methode verändert. Die battle Methode hat nur einen String mit der Gewinnerparty zurück gegeben und nur mit diesem konnten wir schlecht arbeiten. Deswegen hat der DefaultArenaService in der Arena ein neuer Rückgabewert erhalten und zwar eine Liste von den Parties, die gekämpft haben. Zusätzlich hat die Party ein neues Feld "isWinner" erhalten. Somit konnte die Verarbeitung der Daten besser gestaltet werden. Der DefaultPromoterService hat auch ein Upgrade bekommen, dieser gibt den Heroes verschiedene Partynamen und schaut, dass im gleichen Kampf nicht derselbe Name existiert. 

## Jetziger Stand

## Betriebsanleitung
