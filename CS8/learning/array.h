#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

#ifndef ARRAY_H
#define ARRAY_H

class testArray{
  
   public:
      int varA;
      int varB;
      char varC;
      void print();
      void input();
      void comp();
      double arrA[];
      string arrB[];
};
 #endif






 class Student
{
    private:
        int age, standard;
        string first_name, last_name;

    public:
        void set_age(int a)
        {
            age = a;
        }

        void set_first_name(string b)
        {
            first_name = b;
        }

        void set_last_name(string c)
        {
            last_name = c;
        }

        void set_standard(int d)
        {
            standard = d;
        }

        int get_age()
        {
            return age;
        }

        string get_first_name()
        {
            return first_name;
        }

        string get_last_name()
        {
            return last_name;
        }

        int get_standard()
        {
            return standard;
        }

        string to_string()
        {
            stringstream e;
            e << age << "," << first_name << "," << last_name << "," << standard;
            return e.str();
        }
};