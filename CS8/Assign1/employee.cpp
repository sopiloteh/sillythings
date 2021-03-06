/********************************************************
 * AUTHOR   : Erick Bravo 
 * Lab #2   : Employee
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 2/22/21
 ********************************************************/

#include "employee.h"

//default constructor
employee::employee()
{
   name = "";
   id = "";
   salary = 0;
   biWeekly = 0;
   gender = "";
   age = 0;
   hoursWorked = 0;
}

// construtor to assign values to the following
employee::employee(std::string a, std::string b, double c,std::string gender, double age, double hours)
{
   name = a;
   id = b;
   salary = c;
   this->gender = gender;
   this->age = age;
   this->hoursWorked = hours;
}

//function to return the annual salary
double employee::yearlySalary()
{
   return salary*40*4*12;
}

//function to increment the salary
double employee::incSalary(double inc)
{
   salary = salary + (salary/inc);
}

//function to calculate the two week check
double employee::find_biWeekly()
{
   return salary*80;
}

//function to calculate overtime over 40 hours
double employee::calcOvertime(double a)
{
   if (a > 40)
   {
      return 200 * (a-40);
   }
}

//boolean to see if its equal to
bool employee::operator==(const employee& rhs)
{
   return (name == rhs.name && id == rhs.id && salary == rhs.salary && biWeekly == rhs.biWeekly && gender == rhs.gender && age == rhs.age);
}

//boolean for less than
bool employee::operator <(const employee& rhs)
{
   return name < rhs.name;
}

//boolean for greater than
bool employee::operator >(const employee& rhs)
{
   return name > rhs.name;
}

//boolean for less than or equal to
bool employee::operator <=(const employee& rhs)
{
   return (*this == rhs|| *this < rhs);
}

//boolean for greater than or equal to
bool employee::operator >=(const employee& rhs)
{
   return (*this == rhs|| *this > rhs);
}

//boolean for not equals
bool employee::operator != (const employee& rhs)
{
   return !(*this == rhs);
}

//prints data
void employee::printData() const
{
   std::cout << "Name: " << name << "\nid: " << id
   << "\nSalary: $ " << salary << "\nGender: " << gender
   << "\nAge: " << age << "\nHours: " << hoursWorked << "\n";
}