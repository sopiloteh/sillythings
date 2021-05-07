#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

#ifndef BOOL_H
#define BOOL_H


class fish
{
   public:
      fish();
      int a,c;
      vector <int> bob;
      void print();
      void printDup();
      void verify();
      void vector2();
   private:
      bool yesBob;
};

void fish::print(vector <int> bob){
   cout << "this is what you inputted, but now in classes!\n\n";
   for (int i =0; i < bob.size(); i++){
      cout << bob.at(i) << ' ';
   }
}

void fish::printDup(vector <int> bob){
   vector <int> dupes;
   sort(bob.begin(), bob.end());
   for(int i =0; i < bob.size(); i++){
      if(bob[i-1] == bob[i]){
         if (dupes.empty()){
            dupes.push_back(bob[i]);
         }
      }
   }
   if (dupes.size() == 0){
      cout << "\n there are no duplicates here right now!\n";
   }
   else{
      for (int i = 0; i < dupes.size(); i++){
         cout << "\nthere are some duplicates here : " << dupes[i] << "\n";
      }
   }
}

void fish::verify(){

}

void fish::vector2(int a, int c){

}

 
#endif