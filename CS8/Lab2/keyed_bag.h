/********************************************************
 * AUTHOR   : Ellen Yim & Erick Bravo
 * Lab #2   : Bag(s)
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 2/22/21
 ********************************************************/

#ifndef KEYED_BAG_H
#define KEYED_BAG_H

#include <cassert>
#include <stddef.h>
#include <iostream>

//creating a custom namespace as to compartamezalize keyed_bag
namespace mydata
{
	class keyed_bag
	{
		public:
      keyed_bag();

      //size_t data type is an integer data type that can hold
      //only non-negative numbers.  Each C++ implementation
      //guarantees that the values of the size_t type can hold the
      //size of any variable that can be declared on your machine.
		typedef int value_type;
		typedef std::size_t size_type;
		static const size_type CAPACITY = 30;

      // removes an item when requested too from the marked bag
		void remove(const int& key);

      // adds a paired item into the marked bag
		void insert(const value_type& entry, int key);

      // adds two obejects into the marked bag
		void operator +=(const keyed_bag& addend);

      //returns the amount of items in the bag
		size_type size() const{return used;}

      //counts how many of the item occur in the marked bag
		size_type count(const value_type& target) const;
		
      // finds a certain item if its in the bag
		bool isPresent(int key) const;

      // prints the bag when requested
		void print_bag() const;

		private:
		value_type data[CAPACITY];
		int keys[CAPACITY];
		size_type used;
	};

   // allows objects to be added to the class
	keyed_bag operator +(const keyed_bag& b1, const keyed_bag& b2);
}
#endif
