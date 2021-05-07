#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

#ifndef VECTORS_H
#define VECTORS_H
 
 //pr0toTyp3s
void vector1();
void vector2();
void print();
void printDup();
void verify();


// answer derived from discussion on hackerrank
void vector1()
{
   int n, q, size, value, which, index;
    cin >> n >> q;
    //this creates a new vector of type int
    vector<vector<int> > nvec;
    // this for loop increases goes forward for however big of a number they declared
    // size is what will be 
    for (int i = 0; i < n; ++i) {
        cin >> size;
        vector<int> ivec;
        for (int j = 0; j < size; ++j) {
            cin >> value;
            ivec.push_back(value);
        }
        nvec.push_back(ivec);
    }
    for (int k = 0; k < q; ++k) {
        cin >> which >> index;
        cout << nvec[which][index] << endl;
    }
}

// this prints out whatever vector the user inputted
void print(vector <int> bob)
{
    cout << "This is what you inputted into the vector: \n";
    for(int i=0; i < bob.size(); i++){
        cout << bob.at(i) << ' ';
    }
}

// this prints out any duplicates that the user may have inputted into the vector
void printDup(vector <int> bob)
{
   // an additional vector is needed to put the duplicate entries inside
    vector <int> duplicate;
    // using the sort&end function from the algorithem libary
    sort(bob.begin(), bob.end());
    //for loop using a simple inputs as well as using the vector itself to get the size
    for (int i =1; i<bob.size(); i++){
      //starting from the end and then working down to the start
        if (bob[i-1] == bob[i]){
      //at the start the second vector is empty so it needs to be filled
            if (duplicate.empty()){
                duplicate.push_back(bob[i]);
            }
      //when the second vector has one item inside then the first array dumps into the second array
      //only when it the items 
            else if (bob[i] != duplicate.back()){
                duplicate.push_back(bob[i]);
            }
        }
    }

    if (duplicate.size() == 0){
        cout << "\nno duplicates here!\n";
    }
    else{
        for (int i =0; i < duplicate.size(); i++){
            cout << "\nclearly youve entered some dupes: " << duplicate[i] << "\n";
        }
    }
}

void vector2()
{
   int a,c;
   cout <<"enter in a number: \n";
   cin >> a;
   vector <int> bob;
   cout << "youll now enter in up to "<< a << " numbers into the vector\n";
   for (int i = 0; i<a; ++i){
      cin >> c;
      bob.push_back(c);
   }
   print(bob);
   printDup(bob);
}

void verify(vector <int> bob)
{
//    if ( )
//    print(bob);
//    printDup(bob);
}

 
#endif



