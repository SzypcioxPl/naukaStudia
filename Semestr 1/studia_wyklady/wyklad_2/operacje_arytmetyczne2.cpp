#include <iostream>

using namespace std;

int main(){

  int a = 3;
  int b = 2;
  int c = 7;
  int d = 1;

  cout << a << endl;
  cout << b << endl;
  cout << c << endl;
  cout << d << endl;

  int x = 0;
  x = x + a;
  cout << x << endl;
  x = x + b;
  cout << x << endl;
  x = x + c;
  cout << x << endl;
  x = x + d;
  cout << x << endl;

  int y = a + b + c + d;
  cout << y << endl;

  int x1 = a + b;
  cout << x1 << endl;
  int x2 = c + d;
  cout << x2 << endl;
  int r = x1 + x2;
  cout << r << endl;

}