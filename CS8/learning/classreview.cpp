#include <iostream>

class throttle //class head
{
   //member list of all functions avalible to class
   public: // public functions are avalible outside the function
      void shutoff();
      void shift(int amount);
      double flow() const; //when const is applied to member function, it allows it to be read only
      bool isOn() const;
      //throttle();
   private: //stores information useful to the member functions, but outside of the class are not avalible
      int position;
};
/*
this lets you shift the throttle since it is a member function
it takes the input from main and then passes it. it is then passed into another variable
this variable then does an if else statement, less then 0 it starts at 0, bigger then 6
it is forced at 6
*/
void throttle::shift(int amount)
{
   position += amount;
   if (position < 0)
      position = 0;
   else if (position > 6)
      position = 6;
}

//when position reaches 0 then the fucntion stops due to the while statement
void throttle::shutoff()
{
   position = 0;
}

//this allows the user to see how much flow is coming out by dividing the input by 6.0
//doing only 6 makes it have a logicagl error while 6.0 shows you decimal points
double throttle::flow() const
{
   return position/6.0;
}

//the :: operator is what allows the function in the class to be accessed by int main
//since of course it has the operations inside 
bool throttle::isOn() const
{
   return (flow() > 0);
}

int main()
{  
   //constructor to use functions from class inside main
   throttle control;
   int userInput;
   
   std::cout << "please type a num from 0 to 6\n";
   std::cin >> userInput;
   //dot operator is called to attach the constructor to the variable for use.
   control.shutoff();
   control.shift(userInput);
   
   while (control.isOn())
   {
      std::cout << "the flow is " << control.flow() << "\n";
      control.shift(-1);
   }
      std::cout << "the flow is off\n";
   return 0;
}