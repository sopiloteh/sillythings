#include <iostream>
using namespace std;

typedef int* IntPointer;

void sneaky(IntPointer temp);

int main()
{
    // intpointer is a typedef which illl need to reasereach 
    //
    IntPointer p;
    // p is called as a new int which is th same as int p?
    p = new int;
    // this is where it forces the memory to 77
    *p = 77;
    cout << "Before call to function *p == " << *p << endl;

    // this is where it gets sucked into the new void
    sneaky(p);

    // after emtering through sneaky(p) the new memory is now p
    cout << "After call to function *p == " << *p << endl;

    return 0;
}

// this function takes in the p variable
void sneaky (IntPointer temp)
{
    // this forces  p which goes into temp which is pointed to *temp males it 99
    *temp = 99;
    cout << "Inside function call *temp == " << *temp << endl;
}