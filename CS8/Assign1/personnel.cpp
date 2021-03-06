/********************************************************
 * AUTHOR   : Erick Bravo 
 * Lab #2   : Employee
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 2/22/21
 ********************************************************/

#include "employee.h"
#include "personnel.h"

void personnel::add(employee e) 
{
  seq.attach(e);
}

//allows the employees to get an average age
double personnel::getAverageAge() 
{
  seq.start();
  double totalAge = 0.0;
  int num = 0;
  while (seq.is_item()) 
  {
    totalAge += seq.current().getAge();
    num++;
    seq.advance();
  }
  return totalAge / num;
}

//function allows the salaries to be averaged together getting it from the sequence
double personnel::getAverageSalary() 
{
  seq.start();
  double totalSalary = 0.0;
  int num = 0;
  while (seq.is_item()) {
    totalSalary += seq.current().getSalary();
    num++;
    seq.advance();
  }
  return totalSalary / num;
}

//getting the function to show number of hours worked in whole
double personnel::getNumberOfHoursWorked() 
{
  seq.start();
  double totalHoursWorked = 0.0;
  while (seq.is_item()) 
  {
    totalHoursWorked += seq.current().getHours();
    seq.advance();
  }
  return totalHoursWorked;
}

//gets the function to show overtime hours over 40
double personnel::getNumberOfOvertimeHours() 
{
  seq.start();
  double totalOvertimeHours = 0.0;
  while (seq.is_item()) {
    totalOvertimeHours += (seq.current().getHours() - 40);
    seq.advance();
  }
  return totalOvertimeHours;
}

//allows the function to show the female male balance
double personnel::getGenderRatio() 
{
  seq.start();
  double males = 0.0;
  double females = 0.0;
  while (seq.is_item()) {
    if (seq.current().getGender() == "male") 
    {
      males += 1.0;
    }
    else if (seq.current().getGender() == "female") 
    {
      females += 1.0;
    }
    seq.advance();
  }
  return males / females;
}