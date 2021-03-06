/********************************************************
 * AUTHOR   : Erick Bravo 
 * Lab #2   : Employee
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 2/22/21
 ********************************************************/

#include "sequence.h"
sequence::sequence() 
{
    current_index = 0;
    used = 0;
}

// starts the sequence at well zero
void sequence::start() 
{
  current_index = 0;
}

//allows the index/sequence to move forward
void sequence::advance( ) 
{
  if (current_index < used ) 
  {
    current_index++;
  }
}

//allows an object to be inserted into the sequence at the front
void sequence::insert(const value_type& entry) 
{
  if (current_index < used) 
  {
    for (int i = used; i>current_index; i--) 
    {
      data[i] = data[i-1];
    }
    data[current_index] = entry;
  }

  else 
  {
    for (int i = used; i>0; i--) 
    {
      data[i] = data[i-1];
    }
    data[0] = entry;
    current_index = 0;
  }
  used++;
}

//allows an object to be inserted into the sequence at the end
void sequence::attach(const value_type& entry) 
{
  if (current_index < used) 
  {
    for (int i = used-1; i>current_index; i--) 
    {
      data[i+1] = data[i];
    }
    data[current_index+1] = entry;
    current_index++;
  }

  else 
  {
    data[used] = entry;
  }
  used++;
}

// allows an object to be removed from a certain point    
void sequence::remove_current( ) 
{
  for (int i = current_index; i<used-1; i++) 
  {
    data[i] = data[i+1];
  }
  used--;
}

 
sequence::size_type sequence::size( ) const 
{
  return used;
}

bool sequence::is_item( ) const 
{
  return current_index < used;
}

sequence::value_type sequence::current( ) const 
{
  return data[current_index];
}