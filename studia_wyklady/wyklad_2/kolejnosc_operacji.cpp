#include <iostream>

using namespace std;

int main(){

  int a = 1 + 2 * 3;
  int b = 2 * 3 + 1;
  int c = 2 * (3 + 1);

  cout << a << endl;
  cout << b << endl;
  cout << c << endl;

  a = 2 - 2 - 2;
  b =(2 - 2) - 2;
  c = 2 - (2 - 2);

  cout << a << endl;
  cout << b << endl;
  cout << c << endl;

  c = 2-(a = 1);
  a = (b = 3, b + 2);

  cout << a << endl;
  cout << c << endl;

}