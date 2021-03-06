#include "bag.h"
#include <algorithm>


bag::bag():used(0){}

bag::size_type bag::count(const value_type& target) const
{
    size_type answer;
    size_type i;
    answer = 0;
    for (i = 0; i < used; ++i)
        if(target == data[i])
            ++answer;
    return answer;
}

void bag::insert(const value_type& entry)
{
    assert(size() < CAPACITY);
    data[used] = entry;
    ++used;
}

//provided the target is actually in the bag, function removes
//one copy of target and returns true, otherwise returns false
bool bag::erase_one(const value_type& target)
{
    size_type index;

    index = 0;
    while((index < used) && (data[index] != target))
        ++index;

    if(index == used)
        return false;

    --used;
    data[index] = data[used];
    return true;
}

bag::size_type bag::erase(const value_type& target)
{
    size_type index = 0;
    size_type many_removed = 0;

    while(index < used)
    {
        if(data[index] == target)
        {
            --used;
            data[index] = data[used];
            ++many_removed;
        }
        else
            ++index;
    }

    return many_removed;
}

void bag::operator+=(const bag& addend)
{
    assert(size() + addend.size() <= CAPACITY);

    std::copy(addend.data, addend.data + addend.used, data + used);
    used += addend.used;
}

bag bag::operator+(const bag& b)
{
    bag answer;

    assert(this->size() + b.size() <= bag::CAPACITY);

    answer += *this;
    answer += b;
    return answer;
}

bag bag::operator-(const bag& b)
{
    bag ans;

    assert(this->size() - b.size() >= 0);

    ans -= *this;
    ans -= b;
    return ans;
}

void bag::operator-=(const bag& subtract)
{
    assert(size() - subtract.size() >= 0);

    std::copy(subtract.data, subtract.data - subtract.used, data - used);
    used -= subtract.used;
}


