/********************************************************
 * AUTHOR   : Ellen Yim & Erick Bravo
 * Lab #2   : Bag(s)
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 2/22/21
 ********************************************************/

#include "keyed_bag.h"

namespace mydata
{
	keyed_bag::keyed_bag()
	{
		used = 0;
		for (int i = 0; i < CAPACITY; i++)
		{
			keys[i] = 0;
		}
	}

	void keyed_bag::insert(const value_type& entry, int key)
	{
		assert(size() < CAPACITY);
		if(isPresent(key))
		{
			return;
		}
		for (int i = 0; i < CAPACITY; i++)
		{
			if (keys[i] == 0)
			{
				data[i] = entry;
				keys[i] = key;
				used++;
				break;
			}
		}
	}

	void keyed_bag::remove(const int& key)
	{
		assert(key != 0);
		for (int i = 0; i < CAPACITY; i++)
		{
			if (keys[i] == key)
			{
				used--;
				keys[i] = 0;
			}
		}
	}

	void keyed_bag::operator +=(const keyed_bag& addend)
	{
		for (int i = 0; i < CAPACITY; i++)
		{
			if(addend.keys[i] !=0)
			{
				insert(addend.data[i],addend.keys[i]);
			}
		}
	}

	keyed_bag::size_type
   keyed_bag::count(const value_type& target) const
   {
      size_type answer;
      size_type i;
      answer = 0;

      for (i = 0; i < CAPACITY; ++i)
      {
         if (keys[i] != 0 && target == data[i])
         {
            ++answer;
         }
      }
      return answer;
   }

   keyed_bag operator +(const keyed_bag& b1, const keyed_bag & b2)
   {
      keyed_bag answer;
      assert(b1.size() + b2.size() <= keyed_bag::CAPACITY);
      answer += b1;
      answer += b2;
      return answer;
   }

   void keyed_bag::print_bag() const
   {
      for (int i=0; i < CAPACITY; i++)
      {
         if (keys[i] != 0)
         {
            std::cout << "key: " << keys[i] << " value: " << data[i] <<"\n";
         }    
      }
   }

   bool keyed_bag::isPresent(int key) const
   {
      assert(key != 0);
      for (int i = 0; i < CAPACITY; i++)
      {
         if (keys[i] == key)
         {
            return true;
         }
      }
      return false;
   }

}