#include <iostream>

using namespace std;

int main(){

  int a = 1;
  a = a + 1;
  cout << a << endl;

  int b = 1;
  b += 1;
  cout << b << endl;
  b *= a + 1;
  cout << b << endl;
 
  cout << endl;

  float z = 1;
  z = z + 1;
  cout << z << endl;
  z += 1;
  cout << z << endl;

  z++;

  ++z;

  z = 0;
  float y = ++z;
  cout << y << endl;

  z = 0;
  float x = z++;
  cout << z << endl;

}