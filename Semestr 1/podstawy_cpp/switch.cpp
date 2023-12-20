#include <iostream>

using namespace std;

int main(){

  int dzien = 0;
  cout << "Podaj dzien tygodnia: ";
  cin >> dzien;

  /*
    - break - instrukcja skoku, wyrzucająca nas z danego bloku kodu
  */

  switch(dzien)
  {
    case 1:
      cout << "Poniedzialek";
      break;
    case 2:
      cout << "Wtorek";
      break;
    case 3:
      cout << "Sroda";
      break;
    case 4:
      cout << "Czwartek";
      break;
    case 5:
      cout << "Piatek";
      break;
    default:
      cout << "Weekend";
  }

}