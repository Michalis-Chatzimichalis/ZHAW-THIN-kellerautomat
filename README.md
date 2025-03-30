# Theorie

Umgekehrte polnische Notation
Damit zusammengesetzte Ausdrücke auch ohne Klammern geschrieben werden können, hat
der polnische Mathematiker Jan Lukasiewicz eine Notation entworfen, welche die Operatoren
nach den Zahlen und Variablen (und nicht dazwischen) aufführt. Die Notation wird Umgekehrte
polnische Notation1 genannt.

Anstelle von ’3 + 4’ schreibt man hier ’3 4 +’. Damit können auch zusammengesetzte Ausdrücke
ohne Klammern geschrieben und eindeutig interpretiert werden. Ein weiteres Beispiel: Für
’(3 + 4) ∗ (6 − 2)’ schreibt man ’3 4 + 6 2 − ∗’. Es wird also zuerst ’3 + 4’ berechnet, danach
’6 − 2’ und am Schluss werden die beiden Faktoren miteinander multipliziert. Das Resultat der
Berechnung beträgt 28.

Man darf sich vorstellen, dass die Zahlen der Reihe nach in den Keller, bzw. auf den Stack
geschrieben werden. Wird ein Operator eingelesen (bzw. kommt als Eingabe), so werden die
beiden obersten Zahlen vom Stack genommen, miteinander verrechnet und das Resultat wieder
auf dem Stack gelegt.

# Aufgabe

Implementieren Sie einen deterministischen Kellerautomaten, welcher eine UPN berechnet, mit
einer Programmierumgebung Ihrer Wahl.
Hinweis: Diese Aufgabe kann unabhängig von Aufgabe 1 gelöst werden.

Folgende Implementationen werden erwartet:
- Einen **deterministischen Kellerautomaten**, für einstellige Zahlen und die Operatoren +
und ∗. Die Zahlen im Keller, die Zwischenergebnisse und das Endergebnis können mehrstellig
sein. 
- Die Berechnung und Ausgabe des Resultats, sofern das Eingabewort akzeptiert wird. Für
die Berechnung der zwei Grundrechenarten dürfen die üblichen Operatoren der Programmiersprache verwendet werden.
- Der Keller/Stack. Dieser darf nicht mit einer Bibliotheksklasse (wie java.util.Stack) implementiert werden.
- Ausgabe des ganzen Programms mit zwei Modi, 
  - ein Step-Modus: Ausgabe von dem Inhalt des Kellers, danach etwa ≈ 1 Sekunde
  warten. Dies für jeden einzelnen Berechnungsschritt. Abschliessend das Resultat. 
  - ein Laufmodus: einmalige Ausgabe des Resultats nach Abschluss der ganzen Berechnung