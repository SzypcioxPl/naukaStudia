#include <iostream>

using namespace std;

int main(){

int a1 = 12;
int a2 = 24;
int b1 = a1 | a2;

int b2 = a1 & a2;
int b3 = b2 >> 1;

int b4 = b1 << 2;

int b5 = b4 >> 0;

int b6 = b4 >> 9;

cout << b1 << endl;
cout << b2 << endl;
cout << b3 << endl;
cout << b4 << endl;
cout << b5 << endl;
cout << b6 << endl;

}