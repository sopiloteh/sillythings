/**
 * Main application that uses the Color class.
 * 
 * Copyright (c) 2020, Sekhar Ravinutala.
 */

//this pulls in all the functions contrained in here
#include "color.h"

int main() {
  // dumps into color
  Color c1(0.5, -1, 2);
  // this dumps out the result
  dump(c1);  // (0.50, 0.00, 1.00)
}