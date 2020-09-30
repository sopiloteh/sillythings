#include <iostream>
using namespace std;

class Distance
{
    private:
        int meters;
    public:
        Distance()
        {
            meters = 0;
        }
        void displayData()
        {
            cout << "Meters value: " << meters << endl;
        }

    // you can add friend function to be accessed by
    // the outside function, YOU MUST DECLARE FRIEND
    // it needs to also use the & parameter to 
    // pass by reference since it needs to change,
    // passing it by value sends a copy and that only
    // changes the local copy not the overall copy
    friend void addValue(Distance &d);
};

// function that uses the friend function
// you also need to continue using the & paramter to
// link up the passing by refernce variable
void addValue(Distance &d)
{
    d.meters = d.meters +5;
}

int add(int a, int b) //1
{
    cout << "Function 1\n";
    return a + b;
}

double add(double a , double b) //2
{
    cout << "Function 2\n";
    return (a+b);
}

int add(int a, int b, int c) //3
{
    cout << "Function 3\n";
    return (a+b+c);
}

double add(int a , double b) //4
{
    cout << "Function 4\n";
    return (a+b);
}

double add(double a , int b) //5
{
    cout << "Function 5\n";
    return (a+b);
}

int main()
{   
    Distance d1;
    d1.displayData();

    //friend function called and the value being
    //passed by reference
    // didnt need to use d1. etc only as a paramter
    addValue(d1);
    d1.displayData();
    

    cout << "Function Overloading\n\n\n\n\n\n\nStarts now\n";
    /*
    this is where two or more functions can have the same name
    but different paramters, it can be considered polymorphisim

    it might have differnt types, numbers or sequences of 
    parameters, examples as follows

    void print();
    void print(int a);
    void print(float a);
    void print(int a, int b);
    void print(int b, int a);
    all examples of being overloaded


    */

   cout << add(1,2) << endl; //1
   cout << add(3.5,4.5) << endl; //2
   cout << add(3,4,5) << endl; //3
   cout << add(3,4.5) << endl; //4
   cout << add(3.5,4) << endl; //5


return 0;
}

