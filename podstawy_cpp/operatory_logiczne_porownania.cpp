#include <iostream>

using namespace std;

string odp(bool w){
  string wynik = w ? "Prawda(1)" : "Falsz(0)";
  return wynik;
}

int main(){

  bool test = true;
  // operatory porównania
  test = 5 == 2; // fałsz
  cout << "Wynik z 5 == 2 : " << odp(test) << endl;

  test = 5 != 2; // prawda
  cout << "Wynik z 5 != 2 : " << odp(test) << endl;

  test = 3 > 5; // fałsz
  cout << "Wynik z 3 > 5 : " << odp(test) << endl;

  test = 3 < 5; // prawda
  cout << "Wynik z 3 < 5 : " << odp(test) << endl;

  test = 5 >= 5; // prawda
  cout << "Wynik z 5 >= 5 : " << odp(test) << endl;

  test = 5 <= 5; // prawda
  cout << "Wynik z 5 <= 5 : " << odp(test) << endl << endl;

  /*
    - operatory te są dwuargumentowe
    - wzięcie czegoś w nawias może powodać, iż wyrażenie w nawiasie, będzie
      traktowane jak jeden argument
    - operatory mają swój priorytet, jedne są sprawdzane przed innymi
  */

  // operatory logiczne
  test = !(5 == 5); // fałsz, negacja "!", jedyny operator jednoargumentowy w tej lekcji
  cout << "Wynik z !(5 == 5) : " << odp(test) << endl;

  test = !false; // prawda
  cout << "Wynik z !false : " << odp(test) << endl;

  test = false || true; // prawda, wystarczy jedna prawda aby operator "or" zwrócił prawdę
  cout << "Wynik z false || true : " << odp(test) << endl;

  test = false && true; // fałsz, wystarczy jeden fałsz aby operator "and" zwrócił fałsz
  cout << "Wynik z false && true : " << odp(test) << endl << endl;

  test = false || !(5 > 3) && 10 == 10;  // and ma większy priorytet od or, and jest sprawdzany pierwszy
  cout << "Wynik z (false || !(5 > 3) && 10 == 10) : " << odp(test) << endl;
  
  test = true || false && false;
  cout << "Wynik z ((true || false) && false) : " << odp(test) << endl;

  test = (true || false) && false; // możemy użyć nawiasów do przeciążenia, aby pierwszy był sprawdzony operator or
  cout << "Wynik z ((true || false) && false) : " << odp(test) << endl;


}