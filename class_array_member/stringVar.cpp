#include <iostream>
using namespace std;

class StringVar
{
    private:
        char *value;
        int maxLength;

    public:
        StringVar(int size);
        StringVar();
        StringVar(const char a[]);
        StringVar(const StringVar& stringObject);
        
        //whats this?
        ~StringVar();
        int length() const;
        void inputLine(istream& ins);
        friend ostream& operator <<(ostream& outs, const StringVar& theString);
};

void converstaion(int maxNameSize);

int main()
{
    converstaion(30);
    cout << "End of demonstration. \n";
    return 0;
}

void converstation(int maxNameSize)
{
    StringVar yourName(maxNameSize), ourName("Borg");
    cout << "What is your name?\n";
    yourName.inputLine(cin);
    cout << "We are " << ourName << endl;
    cout << "We will meet again " << yourName << endl;
}