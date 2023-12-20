#include <iostream>

using namespace std;

int main(){
  /*
    - (typ)nazwaZmiennej typowanie zmiennej na typ podany w nawiasie
    - post-(inkrementacja/dekremantacja), wykonuje się po innych operacja
    - pre-(inkrementacja/dekremantacja), wykonuje się przed innymi instrukcjami
  */

  int a = 5, b = 2;
  int c = a + b; // 7

  // operatory arytmetyczne
  cout << "Wynik: " << a + b + 5 << endl;
  cout << "Wynik: " << a - b - 2 << endl;
  cout << "Wynik: " << a * b * 5 << endl;
  cout << "Wynik: " << ((float)a / b) << endl;
  cout << "Wynik: " << a % b << endl << endl; // % - operator reszty z dzielenia
  
  c += a; // 12, alternatywny zapis c = c + a
  cout << "Wynik: " << c << endl;
  c -= a; // 7, alternatywny zapis c = c - a
  cout << "Wynik: " << c << endl;
  c *= a; // 35, alternatywny zapis c = c * a
  cout << "Wynik: " << c << endl;
  c /= a; // 7, alternatywny zapis c = c / a
  cout << "Wynik: " << c << endl << endl;
  
  // inkrementacja
  c++; // 8, alternatywny zapis c = c + 1 lub c += 1
  cout << "Wynik: " << c << endl;
  
  // dekrementacja
  c --; // 7, alternatywny zapis c = c - 1 lub c -= 1
  cout << "Wynik: " << c << endl;

}