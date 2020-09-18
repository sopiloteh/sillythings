#include <cmath>
#include <cstdio>

class Point {
  // Only visible to class (encapsulation)
 private:
  // Attributes; you're free to change private variables at will
  double _x;
  double _y;

  double _trunc(double v) {
    char buf[0x10];
    sprintf(buf, "%.1lf", v);
    sscanf(buf, "%lf", &v);
    return v;

  }

  // Methods; public methods are promises to outsiders
 public:
  // Constructor: notice no return type and name (same as of class)
  Point(double x, double y) {
    printf("\nConstructor 1 called!\n\n");
    setX(x);
    setY(y);
  }
  // "Default" constructor, "overloaded" with the other one
  Point() {
    printf("\nConstructor 2 called!\n\n");
  }
  double magnitude() {
    return sqrt(_x * _x + _y * _y);
  }
  // "Mutators" AKA "setters"
  // Use only if inserting additional logic
  void setX(double x) {
    // Only handle quadrant 1
    if (x >= 0) {
      _x = x;
    }
  }
  void setY(double y) {
    if (y >= 0) {
      _y = y;
    }
  }
  // "Accessors" AKA "getters"
  // Use only if modifying the data in some way
  double getX() {
    return _trunc(_x);
  }
  double getY() {
    return _trunc(_y);
  }
};

int main() {
  // Common way to initialize
  Point p1(2, 2);
  printf("Magnitude of p1 = %.1lf\n", p1.magnitude());

  // Another way to initialize
  Point p2 = Point(2, 2);
  printf("Magnitude of p1 = %.1lf\n", p2.magnitude());

  // Yet another way to initialize
  Point p3 = Point(3, 3);
  printf("Magnitude of p1 = %.1lf\n", p3.magnitude());

  // Instatiating default constructor
  Point p4;  // Actually invokes Point(), the default constructor
  p4.setX(2);
  p4.setY(2);
  printf("Magnitude of p1 = %.1lf\n", p4.magnitude());
}