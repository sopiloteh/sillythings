/********************************************************
 * AUTHOR   : Zhikang Liu & Erick Bravo
 * Lab #2   : Dynamic Set
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 03/01/21
 ********************************************************/
#include <cassert>
#include <stddef.h>
#include <iostream>

void great();         // need to make
void greatOrEqual();    // need to make
void lessOrEqual();     // need to make
void set_insert();      //nonmember function to insert
void set_destroy();     //nonmember function to erase dynamic array memory
void set_add();           // need to make
void set_sub();          // need to make

//void set_range()
//void set_create()
//void set_find

int set_low;
int set_high;
bool *set_buffer;

void set_range(const int low, const int high) 
{
  // setting range of set
  set_low = low;
  set_high = high;
}

void set_create() 
{
  // allocating set buffer memory
  set_buffer = new bool[set_high - set_low];
}

void set_destroy() 
{
  // freeing set buffer memory
  delete[] set_buffer;
}

void set_insert(const int data) 
{
  if(!(set_low <= data && data <= set_high)) 
  {
    // data not in range
    // ignore
    return;
  }

  // marking position as occupied
  set_buffer[data - set_low] = true;
}

bool set_find(const int data) 
{
  if(!(set_low <= data && data <= set_high)) 
  {
    // data not in range
    // not found
    return false;
  }

  // returning value at position
  return set_buffer[data - set_low];
}

void set_add(const int data)
{
   std::cout << "\nadding the number " << data << " to see if it is added\n";
   set_buffer[data+set_high] = true;
}

void set_sub(const int data)
{
   std::cout << "\nsubtracting the number " << data << " to see if it is subbed\n";
   set_buffer[data-set_high] = true;
}

void great(const int data)
{
   if (set_high < data)
   {
      std::cout << "\nchecking to see if " << data << " is greater or equal to something inside here\n";
      std::cout << data << " is greater then what is here\n";
   }
}

void greatOrEqual(const int data)
{
   if (set_high <= data)
   {
      std::cout << "\nchecking to see if " << data << " is greater or equal to something inside here\n";
      std::cout << data << " is at least equal or greater then what is here\n";
   }
}

void lessOrEqual(const int data)
{
   if (set_high >= data)
   {
      std::cout << "\nchecking to see if " << data << " is less than or equal to something inside here\n";
      std::cout << data << " is at least equal or less then what is here\n";
   }
   
}

// entry point
int main() 
{
  // creating set
  set_range(1, 10);
  set_create();

  // inserting elements
  set_insert(1);
  set_insert(3);
  set_insert(5);

  // adding elements
  set_add(11);
  
  for (int x = 0; x< set_high; x++)
  {
     std::cout << &set_range << " ";
  }

  // subtracting elements
  set_sub(3);

  // checking a higher number
  great(20);
  // checking at least something equal or higher
  greatOrEqual(11);

  // checking at least equal to the lowest value or lower;
  lessOrEqual(1);


  // checking set state
  assert(set_find(1) == true);
  assert(set_find(2) == false);
  assert(set_find(3) == true);
  assert(set_find(4) == false);
  assert(set_find(5) == true);
  assert(set_find(6) == false);
  assert(set_find(7) == false);
  assert(set_find(8) == false);
  assert(set_find(9) == false);
  assert(set_find(10) == false);
  

  // deleting set
  set_destroy();

  // end of program
  return 0;
}