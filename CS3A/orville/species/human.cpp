/*
All the species aboard the Orville
This is the human species declared here

Copyright (c) 2020, Erick Bravo
*/

#include "species.h"

Human::Human(bool genderVal, double heightVal, double weightVal)
{
    _male = genderVal;
    heightData = heightVal;
    weightData = weightVal;

}

bool Human::isMale()
{
    return _male = false;
}



 