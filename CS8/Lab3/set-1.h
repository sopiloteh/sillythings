#ifndef SET_H
#define SET_H

#include <cassert>
#include <stddef.h>
#include <iostream>
using namespace std;

class set
{
public:
    set();

    typedef int value_type;
    typedef size_t size_type;
    static const size_type CAPACITY = 30;

    size_type size() const {return used;}

    void insert(const value_type& entry);

    bool erase_one(const value_type& target);

    size_type erase(const value_type& target);

    //Postcondition: The return value is true if target is in the set;
    //otherwise the return value is false.
    bool contains(const value_type& target) const;

    set operator +(const set& s);
    void operator+=(const set& add);

    set operator -(const set& s);
    void operator-=(const set& subtract);

    // overloading the relational operators !=, ==, <, >, <=, >=.
    friend bool operator ==(const set& s1, const set& s2)
    {
        return s1 == s2;
    }
    friend bool operator !=(const set& s1, const set& s2)
    {
        return s1 != s2;
    }
    friend bool operator <(const set& s1, const set& s2)
    {
        return s1 < s2;
    }
    friend bool operator >(const set& s1, const set& s2)
    {
        return s1 > s2;
    }
    friend bool operator <=(const set& s1, const set& s2)
    {
        return s1 <= s2;
    }
    friend bool operator >=(const set& s1, const set& s2)
    {
        return s1 >= s2;
    }

    bool isSubsetOf(set& s2);


private:
    value_type data[CAPACITY];
    size_type used;
};

#endif // SET_H
