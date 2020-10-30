/*
All the species aboard the Orville

Copyright (c) 2020, Erick Bravo
*/

#include "species.h"

bool Eevak::isRunning()
{
    return _isRunning;
}

void Eevak::run()
{
    _isRunning = true;
}

void Eevak::stop()
{
    _isRunning = false;
}

