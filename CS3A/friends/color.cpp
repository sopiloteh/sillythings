/**
 * Color class, containing construct and member function definitions.
 * Notice the lack of main() in this.
 * This is the "source file."
 * 
 * Copyright (c) 2020, Sekhar Ravinutala.
 */

#include <cstdio>
#include "color.h"

Color::Color(double r, double g, double b) :
  _r(value(r)), _g(value(g)), _b(value(b)) {
}

void Color::setR(double r) {
  _r = value(r);
}

void Color::setG(double g) {
  _g = value(g);
}

void Color::setB(double b) {
  _b = value(b);
}

// Must be a "friend" function to see the private members
void Color::dump(const char *name) {
  printf("%s: (%.2lf, %.2lf, %.2lf)\n", name, _r, _g, _b);
}

// Operator overloading, note the const
Color Color::operator+(const Color &c) const {
  return Color(
    (_r + c._r) / 2,
    (_g + c._g) / 2,
    (_b + c._b) / 2
  );
}

// Equality operator, note the const
bool Color::operator==(const Color &c) const {
  return _r == c._r && _g == c._g && _b == c._b;
}

// Returns average of sanitized values
double value(double r, double g, double b) {
  return (value(r) + value(g) + value(b)) /3;
}

// Returns sanitized value
double value(double v) {
  if (v < 0) {
    return 0.0;
  }
  if (v > 1) {
    return 1.0;
  }
  return v;
}
