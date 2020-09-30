/**
 * Class to demo features.
 *
 * Copyright (c) 2020, Sekhar Ravinutala.
 */

#include <cstdio>
#include <String>

/**
 * The private attributes _r, _g, _b, along with the
 * public methods addRed() and red() implement part of
 * the ADT (Abstract Data Type) functionality.
 */
class Color {
 private:
  double _r;
  double _g;
  double _b;

 public:
  Color(double r, double g, double b) : _r(r), _g(g), _b(b) {
  }
  /**
   * Single parameter constructor, for initialization
   * with a single double value (for monochromatic).
   * Don't use this!
   */
  Color(double rgb) : _r(rgb), _g(rgb), _b(rgb) {
  }
  // Force initializing with constructor
  explicit Color(std::string rgb) {
    _r = _g = _b = stod(rgb);
  }
  void dump() {
    printf("(%.1lf, %.1lf, %.1lf)\n", _r, _g, _b);
  }
  void addRed(double r) {
    _r += r;
  }
  double red() {
    return _r;
  }
};

// Monochrome is "derived class," Color is the "base class"
class Monochrome : public Color {
 public:
  // Delegation with initialization of base class
  explicit Monochrome(double v) : Color(v) {
  }
};

/*example is just taking it from the push inside which starts at monocrhome. It then dumps into Class Color this then in turn
uses the struct thats built to dump into the public function inside Class Color, color to pass the variables on to private variables
im not sure what Class Monochrome does, its just a derived class?

need to explore this more tommorow and do some examples over this so that way i can understand it better, i kinda do but its after
the fact not before ok time for break
*/
int main() {
  Monochrome m1(1.5);
  // Can call dump() because it is inherited
  m1.dump();
}