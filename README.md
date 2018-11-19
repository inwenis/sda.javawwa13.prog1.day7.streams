# Zadania wprowadzające do .stream() API w Java 8

1. zwróć największą liczbę z listy intów.
2. zwróć największą liczbę z listy Integerów.
3. zwróć średnią z listy intów
4. zamień wszystkie Stringi w tablicy na wielkie litery
5. z listy stringów wybierz te które zaczynają się od 'a' i mają dokładnie 3 znaki
6. napisz funkcję, która przyjmie liste Integerów i zwróci jeden string który składa się z wszystkich liczb połączonych przecinkami.

    przykład: [1,2,10] -> "1,2,10"

7. do funkcji z zadania 6 dodaj rozpoznawanie czy liczba jest parzysta czy nieparzysta. Jeżeli liczba jest parzysta poprzedz ja "e", jeżeli jest nieparzysta poprzedź ja "o".

    przykład: [1,2,10] -> "o1,e2,e10"

8. napisz funkcję która zwróci wyraz podany na wejściu od tyłu.
9. napisz funkcję która z listy intów wybierze tyle te które są podzielne przez 3.
10. napisz funkcję która z podanych liczb na wejściu zsumuje te które są większe od 10.
11. Napisz funkcję która dostanie listę imion, każde imie zapisze wielkimi literami i zwróci tylko unikalne imiona. Dodatkowo funkcja ma zwracać maksymalnie 10 imion


# Przetwarzanie danych z pliku fules.csv za pomocą .stream() API

1. napisz klase "Car" przechowującą dane z fuel.csv i wczytaj wiersze z fuel.csv do `List<Car>`
2. 10 modeli o najmniejszym spalaniu
    wypisz nazwę + spalanie
    tip: sortowanie
3. napisz kolejną klasę przechowującą informację o samochodach ale z spalaniem podanym w l/100km
    tip: projekcja
4. poprzedni wynik posortuj dodatkowo alfabetycznie
    jeżeli 2 modele mają takie samo spalanie pierwszy powinien być ten który jest pierwszy alfabetycznie
5. 10 modeli o najmniejszym spalaniu dla wybranego przez Ciebie producenta
    tip: filtrowanie
6. jeżeli istnieje wybierz taki model BMW który ma spalanie miejskie mniejsze niż 7 l/100Km
    tip: filtrowanie + findFirst
7. jeżeli istnieje wybierz taki model McLaren który ma spalanie miejskie mniejsze niż 14 l/100Km
    tip: filtrowanie + findFirst
8. sprawdź czy wszystkie modele są wyprodukowane przez Porshe
    tip: wszystkie -> ang. all, w stream() jest metoda All()
9. sprawdzy czy istnieje jaki kolwiek model wyprodukowany przez "Fiat", to samo dla "Olds Mobile"
    tip: tak jak poprzednio przyda nam się angielskie słowo -> tym razem "any"
10. pogrupuj modele po producencie i wypisz ilu różnych producentów istnieje
    tip: collect + grouping
11. używając grup z poprzedniego punktu wypisz liczebność każdej grupy
    tip: projekcja
12. wypisz producentów dla których istnieje conajmniej 50 modeli/ 20 modeli
    tip: wszyskiego składowe już znasz ;)
13. dla producentów dla których istnieje conajmniej 20 modeli wypisz wszystkie modele
    tip: flatMap