#include <iostream>

// #define stala 10
const int stala = 10;

int main(){

  int a = 1; // declaration and initialization
  int b(3);
  int c;
  float myNumber; //gives random number from RAM
  c = -3;

  int d = a + b + c;

  std::cout << "d="  << d << std::endl;
  std::cout << "float= " << myNumber << std::endl;
  std::cout << "const int= " << stala << std::endl;

}