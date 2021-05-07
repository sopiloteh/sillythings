#include "array.h"

void testArray::input(){

   cout << "Select Numbers(A) or Strings(B) to enter as your input for the array:\n";
   cin >> varC;
   if ( varC == 'A' || 'a'){
      cout << "Please enter in a some digits to declare your array size: \n";
      cin >> varA;
      cout << "Now enter in " << varA << " string words to fill your array up\n";
      for (int i=0; i<varA; i++){
         testArray::arrA[i];
      }
   }
   else if ( varC == 'B' || 'b'){
      cout << "Please enter in a some digits to declare your array size: \n";
      cin >> varA;
      cout << "Now enter in " << varB << " string words to fill your array up\n";
      for (int i=0; i<varA; i++){
         testArray::arrB[i];
      }
   }
   else{
      cout << "Youve used the wrong input, please try again\nRun this again\n";
   }

   cout << "\nNow that youve entered in some digits or string words, lets see what we can do with them\n";
}

// void testArray::comp(int testArray::*arrA, string testArray::*arrB){
//    int tempA[] = &arrA[];
//    *arrB ==

// }

void testArray::print(){

}

