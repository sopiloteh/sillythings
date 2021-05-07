#include <iostream>
#include <cassert>
#include <iomanip>

//function to take an input then as long as its above absolute zero, do the conversion formula
double celsius_to_fahrenheit(double c)
{
   const double min_celsius = -273.15;
   assert(c >= min_celsius);
   return (9.0/5.0)*c+32;
}

double centi_to_inches(double c)
{
   return (c*2.54);
}
//non return function that takes in anything after the period and then rounds it up or rounds it down
//uses assert() libary to check that its not a negative number, kinda like a built in if else statement
//std::ios allows to read from an input or output stream 
//std::cout.precision gathers the placement, cout.setf sets the amount shown
//printf could have been used in one line
void setup_cout_fractions(int fraction_digits)
{
   assert(fraction_digits > 0);
   std::cout.precision(fraction_digits);
   std::cout.setf(std::ios::fixed, std::ios::floatfield);
   if (fraction_digits == 0)
   {
      std::cout.unsetf(std::ios::showpoint);
   }
   else
   {
      std::cout.setf(std::ios::showpoint);
   }
}

int main()
{
   //variable declerations, needs to be constant as they dont change
   const char heading1[] = " celsius";
   const char hearding2[] = "farenheit";
   const char heading3[] = " centimeters";
   const char hearding4[] = "inches";
   const char label1 = 'c';
   const char label2 ='f';
   const char label3 = 'cm';
   const char label4 ='i';
   const double table_begin = -50.0;
   const double table_end = 50.0;
   const double table_step = 1.0;
   const int width = 9;
   const int digits = 10;

   //changing value variable
   double value1, value2,value3, value4;

   //input into the function
   setup_cout_fractions(digits);
   std::cout << "conversions from " << table_begin << " to " << table_end << "\n";
   std::cout << heading1 << " " << hearding2 << "\n";

   //for loop to take the value and push it to the table start, then continue until the table ends, at each increment the table is moved forward one
   for (value1 = table_begin; value1 <= table_end; value1 += table_step)
   {
      value2 = celsius_to_fahrenheit(value1);
      std::cout << std::setw(width) << value1 << label1 << " ";
      std::cout << std::setw(width) << value2 << label2 << "\n";
   }
   std::cout << std::endl;
   for (value3 = table_begin; value3 <= table_end; value3 += table_step)
   {
      value4 = centi_to_inches(value3);
      std::cout << std::setw(width) << value3 << label3 << " ";
      std::cout << std::setw(width) << value4 << label4 << "\n";
   }   
return 0;
}
/*
from the text, const is used when the program is not allowed to make any changes to the variable in front of it
the syntax is as follows
const <data type> <variable name> = <value>;
nothing else is needed :D

#include <cassert> is a libary that allows a singluar function assert() to filter out bad data
if it does not pass the assert() then the program ends right away, if it does pass then it allows
the rest of the code to continue
*/
