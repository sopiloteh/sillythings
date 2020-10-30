/*
All the species aboard the Orville
This is the moclan declaration
simlar to Humanoids except it lays eggs

Copyright (c) 2020, Erick Bravo
*/

#include "species.h"

Moclan::Moclan(double heightVal, double weightVal)
{
    heightData = heightVal;
    weightData = weightVal;    
}

bool Moclan::isEgg()
{
    return _isEgg = false;
}

Moclan Moclan::layEgg()
{
    egg = _isEgg;
    egg = true;
}

Moclan Moclan::hatch()
{
    crack = _isEgg;
    crack = false;
}

// bool Moclan::isEgg()
// {
//     return _isEgg = true;
// }

// Moclan Moclan::moclanEgg()
// {
//     return moclanEgg;
// }

// Moclan moclanEgg::isEgg()
// {
//     egg = _isEgg;
//     egg = true;
// }




