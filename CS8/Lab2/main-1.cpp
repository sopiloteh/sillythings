/********************************************************
 * AUTHOR   : Erick Bravo & Ellen Yim
 * Lab #2   : Bag
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 2/22/21
 ********************************************************/

#include <iostream>
#include <cstdlib>
#include "bag.h"
#include "set.h"
#include "keyedbag.h"

using namespace std;        // using regular namespace
using namespace mydata;     // using custom namespace for keyed bag

// function to grab user inputted ages into the container
void get_ages(bag& ages);

// function to verify user inputted ages into the container
void check_ages(bag& ages);

// function to grap user inputed numbers in container for (set)
void get_numbers(set& nums);

// function to verify some of inputted numbers in set container.
void check_numbers(set& nums);

// function to grab to show addition and removal of one way bag entry
void get_bags(keyed_bag& bag1);


int main()
{
    cout << "***************************************************" << endl;
    cout << "         Programmed by : Erick Bravo & Ellen Yim \n";
    cout << "         Student ID    : 00856929 & 10325759 \n";
    cout << "         CS008         : MW - 6:30 - 8:35 \n";

    cout << "         Lab #2        : Bag Class \n";
    cout << "***************************************************" << endl;

    bag ages;
    set nums;
    keyed_bag bag1;
    get_ages(ages);         // user input values for bag
    check_ages(ages);       // check ages for bag container
    get_bags(bag1);
    get_numbers(nums);      // user input values for set
    check_numbers(nums);    // check numbers for set container
    cout << "May your family live long ans prosper." << endl;

    return EXIT_SUCCESS;
}

void get_ages(bag& ages)
{
    int user_input;

    cout << "Type the ages in your family." << endl;
    cout << "Type a negative number when you are done:" << endl;
    cin >> user_input;
    while(user_input >=0)
    {
        if(ages.size() < ages.CAPACITY)
            ages.insert(user_input);
        else
            cout << "I have run out of room and can't add that age." << endl;
        cin >> user_input;
    }
}

void check_ages(bag& ages)
{
    int user_input;

    cout << "Type those ages again.  Press return after each age:" << endl;
    while(ages.size() > 0)
    {
        cin >> user_input;
        if (ages.erase_one(user_input))
            cout << "Yes, I've found that age and removed it." << endl;
        else
            cout << "No, that age does not occur!" << endl;
    }
}

void get_numbers(set& nums)
{
    int user_input;

    cout << "Type some numbers: " << endl;
    cout << "Only one copy of any given item. " << endl;
    cout << "Type a negative number when you're done. " << endl;
    cin >> user_input;
    while (user_input >= 0)
    {
        if(nums.size() < nums.CAPACITY) {
            if (!nums.contains(user_input)) {
                nums.insert(user_input);
            }
        }
        else {
            cout << "I have run out of room and can't "
                 << "add any more numbers. ";
            cout << endl;
        }
        cin >> user_input;
    }

}

void check_numbers(set& nums)
{
    int user_input;
    cout << "Type the numbers again. Press return after each number. "
         << endl;
    for (int i=0; i<=nums.size(); i++) {
        cin >> user_input;

        if (nums.erase_one(user_input))
        {
            cout << "Yes i found that number and removed it. " << endl;
        }
        else
        {
            cout << " No, that number does not occur in this set. "
                 << endl;
        }
    }
/*    while (nums.size() == 0) {
        cin >> user_input;
        if (nums.erase_one(user_input)) {
            cout << "Yes I found that number and removed it." << endl;
        } else {
            cout << "No, that number does not occur in this set. " << endl;
        }
    } */
}


void get_bags(keyed_bag& bag1)
{
    std::cout << "inserting values into the keyed bag: \n";
    bag1.insert(20,1);
    bag1.insert(25,-1);
    bag1.insert(75,10);
    bag1.insert(100,400);
    bag1.insert(0,-100);
    bag1.insert(30,1);
    std::cout << "items are bagged\n";
    bag1.print_bag();
    std::cout <<"\n is key -99 in the bag? " << bag1.isPresent(-99) <<"\n";
    std::cout <<"\n is key -99 in the bag? " << bag1.isPresent(-99) <<"\n";
    std::cout <<"\n inserting the same number \n";
    bag1.insert(500,321);
    std::cout <<"\n items in the bag are now \n";
    bag1.print_bag();
    std::cout << "removing a number -1 from the bag\n";
    bag1.remove(-1);
    std::cout <<"\n items in the bag are now \n";
    bag1.print_bag();
    std::cout <<"\n lets count to 20 \n";
    bag1.count(20);
}


