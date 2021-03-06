#include "set.h"

set::set()
{
    used = 0;
}

void set::insert(const value_type &entry)
{
    //set::const;
    assert(size() < CAPACITY);
    if(!contains(entry))
    {
        data[used] = entry;
        ++used;
    }
}

bool set::erase_one(const value_type &target)
{
    size_type i;
    i = 0;
    while ((i < used) && data[i] != target) {
        ++i;
    }
    if (i == used) {
        return false;
    }

    --used;
    data[i] = data[used];
    return true;
}

set::size_type set::erase(const value_type &target)
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


bool set::contains(const value_type &target) const
{
    for (int i=0; i<size(); i++) {
        if (data[i] == target) {
            return true;
        }
    }
    return false;
}


set set::operator +(const set& s)
{
    set answer;

    assert(this->size() + s.size() <= CAPACITY);

    answer += *this;
    answer += s;
    return answer;
}

void set::operator+=(const set& add)
{
    assert(size() + add.size() <= CAPACITY);
    copy(add.data, add.data + add.used, data + used);
    used += add.used;
}

set set::operator -(const set& s)
{
    set answer;

    assert(this->size() - s.size() >= 0);

    answer -= *this;
    answer -= s;
    return answer;
}

void set::operator-=(const set& subtract)
{
    assert(size() - subtract.size() >= 0);
    copy(subtract.data, subtract.data - subtract.used, data - used);
    used -= subtract.used;
}



