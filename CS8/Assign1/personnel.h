/********************************************************
 * AUTHOR   : Erick Bravo 
 * Lab #2   : Employee
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 2/22/21
 ********************************************************/

#include <iostream>
#include <string>
#include "sequence.h"
#include "employee.h"

#ifndef PERSONNEL_H
#define PERSONNEL_H

class personnel              
{
   private:
      sequence seq;

   public:                             //inizlities the class
    void add(employee e);
    double getAverageAge();            //averagees the age
    double getAverageSalary();         //averages the salary
    double getNumberOfHoursWorked();   //averages the hours
    double getNumberOfOvertimeHours(); //averages any overtime
    double getGenderRatio();           //gets the gender ratio
};

#endif