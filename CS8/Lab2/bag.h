/********************************************************
 * AUTHOR   : Ellen Yim & Erick Bravo
 * Lab #2   : Bag(s)
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 2/22/21
 ********************************************************/

#ifndef BAG_H
#define BAG_H

#include <cassert>
#include <stddef.h>

class bag
{
public:
    bag();

    typedef int value_type;

    //size_t data type is an integer data type that can hold
    //only non-negative numbers.  Each C++ implementation
    //guarantees that the values of the size_t type can hold the
    //size of any variable that can be declared on your machine.
    typedef size_t size_type;

    static const size_type CAPACITY = 30;

    size_type size() const{ return used;}
    void insert(const value_type& entry);

    size_type count(const value_type& target) const;


    //provided the target is actually in the bag, function removes
    //one copy of target and returns true, otherwise returns false
    bool erase_one(const value_type& target);

    //removes all copies of the target and return value tells how
    //many copies were removed
    size_type erase(const value_type& target);

    //Union operator - the union of two bags is a new larger bag that contains
    //all the numbers in the first bag plus all the numbers in the second bag
    bag operator+(const bag& b);

    //overloading the += operator to activate the += member function of the
    //first bag and use the second bag as the argument
    //ex first_bag += second_bag;
    void operator+=(const bag& addend);

    // amount of one bag minusing the amount of all numbers in second bag
    // gives us new bag with less amount
    // first bag = first bag - second bag;
    bag operator-(const bag& b);

    // overloading the -= operator to activate -= member function of first
    // bag and second bag as argument in parameter.
    // so first bag = first bag - second bag.
    void operator-=(const bag& subtract);

private:
    value_type data[CAPACITY];
    size_type used;
};


#endif // BAG_H
