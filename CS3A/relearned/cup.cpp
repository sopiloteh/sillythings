#include "cast.h"

class Month
{
  public:
    int months;
    std::string tri;
    int place;
};

//
// Definition of the Month class
//
class Month
{
public:

   Month(int monthNum);
   // Precondition: The parameter monthNum contains a valid
   // month number (1 - 12)
   // Postcondition: The member variable month has been set to
   // the value of the parameter monthNum.

   Month();
   // Sets the member variable month to 1 (defaults to January).

   Month(char fL, char sL, char tL);

   void outputMonthNumber();
   // Postcondition: The member variable month has been output
   // to the screen if it is valid; otherwise a "not valid"
   // message is printed.

   void outputMonthLetters();
   // Postcondition: The first three letters of the name of the
   // month has been output to the screen if the month is
   // valid (1 - 12); otherwise a message indicating the month
   // is not valid is output.

   Month nextMonth();
   // Precondition: The month is defined and valid.
   // Returns the next month as an object of type Month.

private:
   int month;
};


int main()
{

    return 0;
}