class BankAccount_old
{
    // accesable by the class OR by anything inside main as long as its called 
    // by its proxy name in main
    public:
        BankAccount(int dollars, int cents, double rate);
        BankAccount(int dollars, double rate);
        BankAccount();
        void set(int dollars, int cents, double rate);
        void set(int dollars, double rate);
        void update();
        double get_balance();
        double get_rate();
        void output(ostream& outs);

    // can ONLY be used by members of this class ONLY, no other functions outside
    // this function can use it nor can main
    private:
        double balance;
        double intrest_rate;
        double fraction(double percent);
};

/*
abstract data types have some general guidlines such as these
make all the member variables private
make all basic ops that are required in the class member functions public
specificy/dummy proof the public class function
any helper functions(constructors?) private members 
*/

// new class done with abstract data types in mind

#include <iostream>
#include <cmath>

class BankAccount
{
    public:
        BankAccount(int dollars, int cents, double rate);
        BankAccount(int dollars, double rate);
        BankAccount();
        void set(int dollars, int cents, double rate);
        void set(int dollars, double rate);
        void update();
        double get_balance();
        double get_rate();
        void output(ostream& outs);

    private:
        int dollars_part;
        int cents_part;
        double intrest_rate;
        double fraction(double percentage);
        double percent(double fraction_value);
};

BankAccount::BankAccount(int dollars, int cents, double rate)
{
    if ((dollars < 0) || (cents < 0) || (rate < 0))
    {
        std::cout << "Illegal values for money or intrest rate.\n";
        exit(1);
    }
    dollars_part = dollars;
    cents_part = 0;
    intrest_rate = fraction(rate);
}

BankAccount::BankAccount(int dollars, double rate)
{
    if ((dollars < 0) || (rate < 0))
    {
        std::cout << "Illegal values for money or intrest rate.\n";
        exit(1);
    }
    dollars_part = dollars;
    cents_part = 0;
    intrest_rate = fraction(rate);
}

BankAccount::BankAccount():dollars_part(0), cents_part(0),intrest_rate(0.0)
{

}

double BankAccount::fraction(double percent_value)
{
    return (percent_value/100.0);
}

double BankAccount::get_balance()
{
    return (dollars_part + 0.01*cents_part);
}

double BankAccount:: percent(double fraction_value)
{
    return (fraction_value*100)
}

double BankAccount::get_rate()
{
    return percent(intrest_rate);
}

void BankAccount::output(ostream& outs)
{
    outs.setf(ios::fixed);
    outs.setf(ios::showpoint);
    outs.pre
}
int main()
{
    BankAccount account1(100, 2.3), account2;
    std::cout << "account1 initalized as follows:\n";
    account1.output(std::cout);
    std::cout << "account2 initzlized as follows:\n";
    account2.output(std::cout);
    return 0;
}
