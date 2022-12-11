#include <iostream>

using namespace std;

int main(){
  int a = 3;
  int b = 0;
  int c = (a < b);

  cout << c << endl;
  cout << (a > b) << endl;

  cout << (4 + 2 <= 2 * a) << endl;
  bool b1 = true;

  bool b2 = (4 + 2) <= (2 * a);
  bool b3 = 4 + 2 < 2 * a;
}