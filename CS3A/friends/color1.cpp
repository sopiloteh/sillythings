/**
 * Main application that uses the Color class.
 * 
 * Copyright (c) 2020, Sekhar Ravinutala.
 */

#include <iostream>
#include "color.h"

// Macro, replaces calls during pre-processing                              
#define BOOLM(b) ((b) ? "Yes" : "No")

// Same logic, but through a regular function
const char *boolf(bool b) {
  return b ? "Yes" : "No";
}

int main() {
  Color c1(0.5, -1, 2);
  c1.dump("c1");  // (0.50, 0.00, 1.00)

  // Overloading
  printf("\nvalue(0.4, -1, 3) = %.2lf\n", value(0.2, -1, 3));
  printf("value(3.1) = %.2lf\n", value(3.1));

  printf("\n%.2lf, %.2lf\n\n", value(1), value(1.0));

  c1.dump("c1");
  Color c2(0.1, 0.2, 0.1);
  c2.dump("c2");
  Color c3 = c1 + c2;  // Like saying: Color c3 = c1.operato+(c2);
  c3.dump("c3");

  // The behavior is the same
  printf("\nBOOLM: c1 == c2: %s\n", BOOLM(c1 == c2));
  printf("\nboolf: c1 == c2: %s\n", boolf(c1 == c2));
  std::cout << std::endl << BOOLM((c1 == c2)) << std::endl;
}