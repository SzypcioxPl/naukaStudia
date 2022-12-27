#include <iostream>
#include <iomanip>

using namespace std;

int main(){
  
  /*  
    - nie zaczynamy nazwy zmiennej od dużej litery, bądź cyfry
    - używamy liter od a do z, cyfr od 1 do 9 oraz znaku " _ "
    - nazwa zmiennej musi być ciągła, nie może zawierać spacji
    - drugi człon nazwy zmiennej zaczynamy z dużej litery
    - nie dublujemy deklaracji zmiennej
    - zmienna jest zaeklarowaną przestrzenią w pamięci

    - w celu deklaracji stałej dodajemy constt przec typem zmiennej
    - nie może istnieć stała bez wartości
    
  */

  // tekst
  const string stalyTekst = "Warszawa";
  string tekst = "Grzegorz";
  cout << "string: " << tekst << endl;
  cout << "string: " << stalyTekst << endl << endl;

  /*
    - char przechowuje znak lub liczbę o rozmiarze maksymalnie 1 bajta
    - unsigned przed typem danych spowoduje, że zmienna będzie przechowywać jedynie wartości
      dodatnie, a zakres dla ttych liczb się zdwukrotni, gdyż nie będzie potrzebna informacja
      o znaku
    - bez rzutowania na int char zapisany liczbą daje nam znak z tablicy ASCII i na odwrót
  */

  // znaki
  char znak = 127;
  cout << "char: " << (int)znak << ", rozmiar: " << sizeof(char) << " bajtow." << endl << endl;

  /*
    - brak wartości ułamkowych
    - int i long przechowuje taki sam zakres wartości
  */

  // liczby całkowite
  short zmienna1 = 32767;
  cout << "short: " << zmienna1 << ", rozmiar: " << sizeof(short) << " bajtow." << endl;
  int zmienna2 = 2147483647;
  cout << "int: " << zmienna2 << ", rozmiar: " << sizeof(int) << " bajtow." << endl;
  long zmienna3 = 2147483647;
  cout << "long: " << zmienna3 << ", rozmiar: " << sizeof(long) << " bajtow." << endl;
  long long zmienna4 = 9223372036854775807;
  cout << "long long: " << zmienna4 << ", rozmiar: " << sizeof(long long) << " bajtow." << endl;

  /*
    - float rezerwuje jakby osobno pamięć dla części całkowitej i ułamkowej
    - wielkość precyzji po przecinku zależy od wielkości części całkowitej
    - double "podwójnej precyzji"
  */

  // liczby zmienno przecinkowe
  float zmienna5 = 3.141592;
  cout << "float: " << setprecision(7) << zmienna5 << ", rozmiar: " << sizeof(float) << " bajtow." << endl;
  double zmienna6 = 3.141592653589;
  cout << "double: " << setprecision(14) << zmienna6 << ", rozmiar: " << sizeof(double) << " bajtow." << endl;

  /*
    - 
  */

  // logiczne
  bool logiczna = false;
  cout << "bool: " << logiczna << ", rozmiar: " << sizeof(bool) << " bajtow." << endl;
}