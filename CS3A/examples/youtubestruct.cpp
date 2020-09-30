#include <iostream>
#include <cmath>

using namespace std;

struct newperson
{
    //adding members, adding bits of infor for structure
    // char with a variable named name that has space for 20 chars
    char name[20];
    int age;

};

int main()
{
    //declaring the struct inside main code
    // struct - placeholder inside main for the struct
    newperson bucky = 
    {
        // this puts in variables from inside main to
        // inside the struct
        "Bucky", 21
    };

    newperson hoss =
    {
        "hoss jones",45
    };

    // this prints out the struct, you need to do the
    // tag first then the piece of struct that you need
    cout <<" This is how old "<< bucky.name << " is, " <<bucky.age << endl;
    cout <<" This is how old his boss "<< hoss.name << " is, " << hoss.age << endl;
    system("pause");
    return 0;
}