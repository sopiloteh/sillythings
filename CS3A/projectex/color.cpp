/**
 * Color class, containing construct and member function definitions.
 * Notice the lack of main() in this.
 * This is the "source file."
 * 
 * Copyright (c) 2020, Sekhar Ravinutala.
 */

#include <cstdio>
#include "color.h"

// this is a class? it sets the poitner from one to another
Color::Color(double r, double g, double b) :_r(_fix(r)), _g(_fix(g)), _b(_fix(b)) 
{
}

// this inizalites it
void Color::setR(double r) 
{
  _r = _fix(r);
}

// this inizalites it
void Color::setG(double g) 
{
  _g = _fix(g);
}

// this inizalites it
void Color::setB(double b) 
{
  _b = _fix(b);
}

// Must be a "friend" function to see the private members
void dump(Color c) 
{
  printf("(%.2lf, %.2lf, %.2lf)\n", c._r, c._g, c._b);
}

// not sure what this does, i have to play with it more and learn about it
//proabbly have to ask
double Color::_fix(double v) 
{
  if (v < 0) {
    return 0.0;
  }
  if (v > 1) {
    return 1.0;
  }
  return v;
}
