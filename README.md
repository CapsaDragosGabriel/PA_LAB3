# PA_LAB3
 Capsa Dragos Gabriel 2A6
 
 
 Clasa abstracta Node este extinsa de catre:
Switch,
Router, care implementeaza Identifiable
Computer, care implementeaza si Identifiable si Storage

Clasa Location are coordonate pentru adresa nodurilor din retea.

Functia addNode din Network verifica daca exista deja un nod de acel tip cu acelasi nume, iterand prin lista de nodes. Daca nu exista, atunci nodul este adaugat la retea. Daca exista, este afisat in schimb un mesaj care sa avertizeze utilizatorul. 

In vederea rezolvarii temei, am implementat map-ul de costuri ale conexiunii cu celelalte noduri.

In metoda printIdentifiables castez obiectele care sunt instante de tip Computer sau Router la Identifiable  pentru a le obtine adresa ip in vederea sortarii.

In utilizarea algoritmului lui dijkstra am utilizat o functie auxiliara, getClosestNodeIndex, care sa-mi returneze indexul celui  mai apropiat nod nevizitat.

Pentru determinarea celor mai scurte drumuri am folosit algoritmul lui Dijkstra: am ales un nod de start, am folosit un vector pentru nodurile vizitate si un vector pentru costurile drumurilor pana acolo. Apoi, in fiecare nod, am verificat vecinii cu care am conexiune si care nu au fost vizitati, dupa care am continunat analog.
