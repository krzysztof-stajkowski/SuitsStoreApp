# SuitsStoreApp

Projekt końcowy.
Wymagania:
• Projekt oparty o Spring/Spring Boot
◦    Klasa SuitStoreAppApplication
• Projekt musi korzystać z bazy danych MySQL
◦   Tabela główna Suits z wszystkimi towarami (Garnitury i reszta)
◦   Tabela Category połączona relacją OnetoMany do głównej
▪       3 kategorie ubioru: Casual, Business, Sport
◦    Tabela ProductList połączona relacją OnetoMany do głównej
▪       3 typy (w MVP) towarów: Garnitur, Marynarka, Spodnie (użyta m.in. do filtrów)
◦   Tabela MatchTable połączona relacją OnetoMany do głównej – TODO
▪       To będzie przyszła funkcjonalność łacząca te same modele i rozmiary spodni i marynarek do pełnych garniturów (usuwanie 2x i wstawianie 1x)  
• W bazie danych powinny znajdować się co najmniej 3 tabele i dwie relacje.
◦      Póki co 3 tabele działające i 2 relacje
• W aplikacji powinno znajdować się co najmniej 5 widoków (obsługiwanych przez różne adresy URL).
◦   Widoków jest ok 19
• Aplikacja powinna mieć co najmniej jeden formularz (obsługiwany metodą POST).
◦   Formularzy POST jest 4 (Suits add+edit / product add+edit)
▪        W planie jest Crud do kategorii i product list aby użytkownik mógł edytować i znieniać kategorie i dodawać usuwać nazwy produktów 
• Poprawność danych z formularzy powinna być sprawdzana.
◦   Walidacja jest przy dodawaniu i edycji
