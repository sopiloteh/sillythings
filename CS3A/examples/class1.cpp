/**
 * Class to demo features.
 *
 * Copyright (c) 2020, Sekhar Ravinutala.
 */

#include <cstdio>
#include <string>

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
   * No explicit keyword, so don't use this!
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

int main() {
  Color c1 = {0.2, 0.4, 0.3};

  printf("c1.red() = %.1lf\n", c1.red());
  c1.addRed(0.3);
  printf("c1.red() = %.1lf\n", c1.red());

  // Possible because the single parameter constructor
  // is not explicit
  Color c2 = 0.7;
  c2.dump();

  // Color c3 = std::string("0.3") does NOT work!
  Color c3(std::string("0.3"));
  c3.dump();
}