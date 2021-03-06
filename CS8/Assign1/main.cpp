/********************************************************
 * AUTHOR   : Erick Bravo 
 * Lab #2   : Employee
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 2/22/21
 ********************************************************/

#include "employee.h"
#include "personnel.h"

//main function to run the program and allow a user added txt file
int main()
{
  //variables to allow functions to run
  std::string name,id,gender;
  int age,done = 0;
  double wage, hours;
  personnel p;

  std::cout << "Enter the following in order please:\n" <<
  " Employee Name, ID, Wage, Gender, Age, Hours\n" <<
  "Enter -1 at Continue? to exit, any other digit to continue\n\n";

  // for (int i = 0; i<2; i++ )
  while (done != -1)
  {
    //user or text file added portion
    std::cout << "Enter Employee Name: ";
    std::cin >> name;
    std::cout << "Enter Employee ID: ";
    std::cin >> id;
    std::cout << "Enter Employee Wage: ";
    std::cin >> wage;
    std::cout << "Enter gender: ";
    std::cin >> gender;
    std::cout << "Enter age: ";
    std::cin >> age;
    std::cout << "Enter Hours: ";
    std::cin >> hours;


    //calling in employee functions
    employee emp(name, id, wage, gender, age, hours);
    std::cout << "Yearly salary: " << emp.incSalary(10) << "\n";
    std::cout << "incrementing it by 10% is: " << emp.incSalary(10) << "\n";
    std::cout << "Two week check payout: " << emp.find_biWeekly() << "\n";
    std::cout << "Finding overtime: " << emp.calcOvertime(50) << "\n";
    std::cout << emp.getGender() << "\n";
    
    std::cout << std::endl;
    std::cout << "Continue?\n";
    std::cin >> done;
    
    // adds it to the seqeunce 
    p.add(emp);
  }
  
  // a once run item to show the averages overall
  std::cout << "Average employee age: " << p.getAverageAge() << "\n";
  std::cout << "Average employee salary: " << p.getAverageSalary() << "\n";
  std::cout << "Total number of hours worked: " << p.getNumberOfHoursWorked() << "\n";
  std::cout << "Total number of overtime hours: " << p.getNumberOfOvertimeHours() << "\n";
  std::cout << "Male / female gender ratio: " << p.getGenderRatio() << "\n";
  
  return 0;
}