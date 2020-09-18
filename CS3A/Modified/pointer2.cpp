#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
    int *p1,*p2;
    // cannont use regular int, needs to have specific syntax
    //int p1;
    p1 = new int;
    *p1 = 42;
    // this sets the value as 42 and points it to the variable p1
    // p2 and p1 are equals now whatever p1 gets, p2 gets and vice versa
    p2 = p1;
    
    cout << "*p1 == " << *p1 << endl;
    cout << "*p2 == " << *p2 << endl;
    
    *p2 = 53;
    cout << "*p1 == " << *p1 << endl;
    cout << "*p2 == " << *p2 << endl;
    
    // this declares a new instance of p1 and does not  call in the new pointers to be equal, so p2 will carry over not
    // older version of p1
    p1 = new int;
    *p1 = 88;
    
    cout << "*p1 == " << *p1 << endl;
    cout << "*p2 == " << *p2 << endl;
    
    cout << "I hope I understood this example\n";
    return 0;
}
