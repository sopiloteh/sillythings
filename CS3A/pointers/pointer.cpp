/**
 * 
 *
 * Copyright (c) 2020, Erick Bravo.
 */

#include <iostream>
#include <string>
#include <algorithm>

//prototypes
void passByValue(int x);
void passByRef(int *x);

void passByValue(int x)
{
    x = 99;
}

void passByRef(int *x)
{
    *x = 66;
}

int main()
{
    int fish = 5;

    //& address operator

    // this pops out the memory address of where fish is
    std::cout << &fish << std::endl;

    // the * makes it a pointer variable not a regualr pointer
    int *fishPointer;

    // it still needs to be assigned a memory address to look at
    // also no need to put the *  every time, only once

    // this is now equal to where the memory address is
    fishPointer = &fish;

    std::cout << fishPointer << std::endl;

    std::cout << "\n\n\n\nnow on to pass by refference!!\n\n\n";


    // passing by value
    int betty = 13;

    // passing by ref
    int sandy = 13;

    passByValue(betty);
    passByRef(&sandy);

    std::cout << "\nbettey is now " << betty << std::endl;
    std::cout << "\nsandy is now " << sandy << std::endl;

   std::cout << "\n\n\n\nnow on to sizeOF function!!\n\n\n";

   //sizeof is used in cunjunction with pointers but this is without pointers for now

    char c;
    double cup[10];
    std::cout << "\nThis is how big a C is " << sizeof(c) << std::endl;
    std::cout << "\nThis is how big cup  is " << sizeof(cup) << std::endl;
    // this shows how big it takes in memory, bytes really

    // you can use this to find out how many elements in an array are
    std::cout << "This is how many elemnts are in it " << sizeof(cup) / sizeof(cup[0]) << std::endl;

}