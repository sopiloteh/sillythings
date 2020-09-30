/*
this is for in heritance in c++
so we can learn by doing, it implements "IS-A"

for example a tire IS part of A car

this can be used to create classes and then subclasses
to reuse a lot of code, only need to edit in one place
rather then a multitude of classes

main class can have member functions that can be shared
with derived/sub classes

the derivied/sub classes can have thier own memeber 
functions that are private to themselves

many types of classes: single and multi level where you
can have many diffrent classes reaching up

multiple inheritance looks like it is sharing a sub class
it seems like it would be a mom and dad having a kid, 
it would also share variables inside the child class

hierachial inheritance is like a king and his court,
all the sub classes lead up to the king which is the 
main class

lastly hybrid is where there are at least two levels
of classes, the inital levels are seperate BUT
the second level reaches out to the second level,
kinda like multiple inheritance but more complicated

class
{
    public: anyone can access
    protected: some classes can access
    private: no one!
}

class base
{
    public:
    int x;

    protected:
    int y;

    private
    int z;
};

class publicDerived: public base
{
    x is public
    y is protected
    z is not accesable from publicDerived
};

class protectedDerived: protected base
{
    x is protected
    y is protected
    z is not accessable from protectedDerived
};

class privatederived: private base
{
    x is private
    y is private
    z is not accesable from privateDerived
}
*/

#include <iostream>

//base class
class Shape
{
    // kinda like public but saves them?
    protected:
        int width;
        int height;


    public:
        // member functions of Shape
        void setWidth(int w)
        {
            width = w;
        }
        void setHeight(int h)
        {
            height = h;
        }
};

// this is a child class of Shape, Derivied
// child          parent
class Rectangle: public Shape
{
    public:
        int getArea()
        {
            return (width * height);
        }
};

int main()
{
    // calling child class
    Rectangle Rect;

    // this then goes into rectangle subclass which then goes up to the base class
    // since that is where the members are being held   Base <- Derivied <-M
    Rect.setWidth(5);
    Rect.setHeight(7);

    std::cout << "Total area: " << Rect.getArea()<< "\n";

    // it appears you can call a subclass without having to declare the main class since the sub class will wait for it
    //INHERIT all the variables from the main class so only one class has to be called, this makes it easeier to understand now!
    return 0;
}
