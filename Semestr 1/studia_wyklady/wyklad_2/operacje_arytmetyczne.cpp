#include <iostream>

using namespace std;

int main(){

  int x = 1 + 2 + 3 + 4;
  cout << x << endl;
  int y = 20 - x;
  cout << y << endl;
  y = x * 3;
  cout << y << endl;
  float xy = 10 * 0.73;
  cout << xy << endl;
  xy = 10.0 / 7;
  cout << xy << endl;
  int z = x / 3;
  cout << z << endl;
  z = x / 6;
  cout << z << endl;
  z = x % 6;
  cout << z << endl;

  unsigned int u = x - y; 
  cout << u << endl;

}