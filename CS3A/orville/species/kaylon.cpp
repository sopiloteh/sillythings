/*
All the species aboard the Orville
this is just like humans except it fires
lasers!

Copyright (c) 2020, Erick Bravo
*/

#include "species.h"

Kaylon::Kaylon(double heightVal, double weightVal)
{
    heightData = heightVal;
    weightData = weightVal;
}

bool Kaylon::isFiring()
{
    return _isFiring;
}

void Kaylon::startFiring()
{
    _isFiring = true;
}

void Kaylon::stopFiring()
{
    _isFiring = false;
}