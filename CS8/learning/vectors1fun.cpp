#include "vectors1.h"

void test::vector1(){

}

void test::vector2(){
   int a,b;
   cout << "Welcome to Vector inserter!\nThis simple program will allow a user to insert a vector of certain length\n\n\n\n\n";
   cout << "First off lets enter in the size, please choose a digit:\n";
   cin >> a;
   for (int i=0; i<a; i++){
      cin >> b;
      test::bob.push_back(b);
   }
   print(test::bob);

}


void test::print(vector <int> bob){
   cout << "This is what you inputted: \n";
   for(int i=0; i<bob.size();i++){
      cout << bob.at(i) << ' ';
   }
}

void test::printDup(vector <int> bob){
vector <int>;
}

