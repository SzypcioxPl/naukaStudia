#include <iostream>

using namespace std;

int main(){

  int a = 1 << 20;
  short b = a;
  cout << b << endl;
  
  b = 1234;
  a = b;

  float f = 1.9;
  int x = f;
  int c =- 1;
  unsigned int d = c;
  
  // b = (short)a;  C
  // b = short(a);  C
  // b = static_cast<short>(a); C++

  cout << a << endl;
  cout << b << endl;
  cout << f << endl;
  cout << x << endl;
  cout << c << endl;
  cout << d << endl;

}