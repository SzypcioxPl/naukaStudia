#include <iostream>

using namespace std;

int main(){

  int a;
  unsigned int b;
  long int c;
  float d;

  size_t sd = sizeof(d);
  cout << sizeof(a) << "\n";
  cout << sizeof(b) << "\n";
  cout << sizeof(c) << "\n";
  cout << sd << "\n";

}