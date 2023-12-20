#include <iostream>

using namespace std;

int main(){

  /*
    - bez zamieszczania klamerek po if'ie, wykonana zostanie jedynie jedna instrukcja po nim, reszta
      poniżej do if'a należeć nie będzie, będzie wykonana niezależnie od if'a
    - else if() warunek do sprawdzenia jeśli poprzedni miał wynik false
    - else instrukcja do wykonania, jeśli wszystkie wcześniejsze warunki były false
  */

  int a = 5, b = 7;

  if(a > b)
    cout << "A jest mniejsze od B" << endl;
    cout << "nie nalezy do if'a" << endl << endl;
  

  if(a < b)
  {
    cout << "A jest mniejsze od B" << endl;
  }
  cout << "Dla a = " << a <<" i b = " << b << endl << endl;

  a = 7; b = 5;
  if(a < b)
  {
    cout << "A jest mniejsze od B" << endl;
  }else if(a > b)
  {
    cout << "A jest wieksze od B" << endl;
  }
  cout << "Dla a = " << a <<" i b = " << b << endl << endl;

  a = 7; b = 7;
  if(a < b)
  {
    cout << "A jest mniejsze od B" << endl;
  }else if(a > b)
  {
    cout << "A jest wieksze od B" << endl;
  }else // ostatnia możliwość to to, że A jest równe B
  {
    cout << "A jest rowne B" << endl;
  }
  cout << "Dla a = " << a <<" i b = " << b << endl << endl;

  a = 20; b = 20;
  if(a < b)
  {
    cout << "A jest mniejsze od B" << endl;
  }else
  {
    if(a > b)
    {
      cout << "A jest wieksze od B" << endl;
    }else
    {
      cout << "A jest rowne B" << endl;
    }
    cout << "Dla a = " << a <<" i b = " << b << endl << endl;
  }

  // skrócony operator warunkowy, operator trójargumentowy
  string odp = a > b ? "Tak - prawda" : "Nie - falsz"; // warunek ? jeśliPrawda : jeśliFałsz
  cout << "Czy a > b ?: " << odp << endl;
  cout << "Dla a = " << a <<" i b = " << b << endl << endl;
  
}