# Aplikacja Mobilna - Gra w Kości (Kostki)

## Opis Projektu
Aplikacja mobilna zrealizowana w środowisku Android Studio w języku Kotlin oraz przy użyciu układu XML. Gra polega na rzutach pięcioma sześciennymi kośćmi zgodnie z wymaganiami egzaminacyjnymi.

## Spełnione Założenia i Wymagania:
1. **Interfejs użytkownika (XML):**
   - Pięć obrazów kości początkowo ustawionych na `kosc0.png` bez przezroczystości (wszystkie kości dostępne).
   - Przycisk z napisem „RZUT” z odpowiednim tłem (`#ED275021`).
   - Pole tekstowe z wynikiem rzutu (wartość początkowa `0`, rozmiar czcionki 40sp).
   - Tło okna: `#ED27C121`.
   - Marginesy zewnętrzne dla obrazów i przycisku: `10dp`.
   - Wszystkie elementy wyśrodkowane.

2. **Działanie aplikacji po wciśnięciu przycisku RZUT:**
   - Dla dostępnych kości losowana jest liczba oczek od 1 do 6.
   - W kontrolkach obrazu wyświetlana jest grafika odpowiadająca liczbie oczek (`kosc1.png` - `kosc6.png`).
   - Liczona jest suma oczek ze wszystkich kości i wyświetlana w polu tekstowym.

3. **Działanie aplikacji po kliknięciu na obraz kości:**
   - Jeśli kość jest dostępna: ustawiana jest na niedostępną, a przezroczystość (alpha) obrazu ustawiana jest na 50% (`0.5f`).
   - Jeśli kość jest niedostępna: ustawiana jest na dostępną, a obraz wyświetlany jest bez przezroczystości (`1.0f`).

4. **Struktura plików źródłowych w folderze mobilna:**
   - `MainActivity.kt` (główna aktywność z logiką gry)
   - `activity_main.xml` (układ interfejsu użytkownika)
   - `strings.xml` (zasoby tekstowe)
   - `README.md` (niniejsza dokumentacja)
