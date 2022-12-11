#include <iostream>

using namespace std;

int main(){

  char c = 'a';
  char d = 65;
  char e = '1' + 1;
  cout << c << "\n";
  cout << ++c << "\n";
  cout << c+1 << "\n";
  cout << char(c + 1) << "\n";
  cout << d << "\n";
  cout << e << "\n";
  cout << (int)e << "\n";

  char znak = '0';

  cout << endl;

  for(int i = 0; i <= 80; i++){
    cout << char(znak+i) << endl;
  }

}