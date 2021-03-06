/********************************************************
 * AUTHOR   : Erick Bravo 
 * Lab #2   : Employee
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 2/22/21
 ********************************************************/

#include <iostream>
#include <string>

#ifndef EMPLOYEE_H
#define EMPLOYEE_H

class employee               //class to run employee personal details
{
   private:
      std::string name;                   //name of employee
      std::string id;                     //employee tracking number
      double salary;                      //employees monetary gains
      double biWeekly;                    //employees two week check
      double age;                         //age of employee
      double hoursWorked;                 //how long the employee has worked  
      std::string gender;                 //male or female employee

   public:
      employee();                         //inizlities the class
      employee(std::string a, std::string b, double c, std::string gender, double age, double hoursWorked); //calls in the varaibles into the class
      double yearlySalary();                                      //calculates an employees salary per year
      double incSalary(double inc);                               //calculates any bonuses to salary
      double find_biWeekly();                                     //finds the employees two week check
      double calcOvertime(double a);                              //finds an employees overtime if over 40 hours
      
      void setName(std::string name){this->name = name;}          //points to the right name
      void setId(std::string id){this->salary = salary;}          //points to the right salary
      void setAge(double age){this->age = age;}                   //points to the right age
      void setGender(std::string gender){this->gender = gender;}  //points to the right gender
      void setHours(double hours){this->hoursWorked = hours;}     //points to how many hours worked
      std::string getName() const{return name;}                   //returns the name
      std::string getId() const{return id;}                       //returns the id number
      std::string getGender() const{return gender;}               //returns the gender
      double getSalary() const{return salary;}                    //returns the salary
      double getAge() const{return age;}                          //returns the age
      double getBiWeekly() const{return biWeekly;}                //returns the biweekly amount
      double getHours() const{return hoursWorked;}                //returns how many hours worked
      void printData() const;                                     //prints said data

      bool operator ==(const employee& rhs);                      //allows it to be compared to see if its equal
      bool operator < (const employee& rhs);                      //allows it to be compared to see if its less than
      bool operator > (const employee& rhs);                      //allows it to be compared to see if its greater than
      bool operator <= (const employee& rhs);                     //allows it to be compared to see if its less than or equal
      bool operator >= (const employee& rhs);                     //allows it to be compared to see if its greater than or equal
      bool operator != (const employee& rhs);                     //allows it to be compared to see if its not equal to
};

#endif