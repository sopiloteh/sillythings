#include <iostream>
#include <cstdlib>
using namespace std;

// global constant variable
const int MAX_LIST_SIZE = 50;

class TemperatureList
{
    private:
        double list[MAX_LIST_SIZE];
        int size;
    
    public:
        TemperatureList();
        void addTemperature(double temperature);
        bool full() const;
        // declaring friend, this isnt  a member function of class TemperatureList
        friend ostream& operator <<(ostream& outs, const TemperatureList& theObject);        
};

TemperatureList::TemperatureList() : size(0)
{
    // this is empty
}

void TemperatureList::addTemperature(double temperature)
{
    if ( full())
    {
        cout << "Error: adding to a full list.\n";
        exit(1);
    }

    else
    {
        list[size] = temperature;
        size = size + 1;
    }   
}

bool TemperatureList::full() const
{
    return (size == MAX_LIST_SIZE);
}

ostream& operator <<(ostream& outs, const TemperatureList& theObject)
{
    for (int i = 0; i < theObject.size; i++)
    {
        outs << theObject.list[i] << " F\n";
    }
    return outs;
}

int main()
{
    return 0;
}