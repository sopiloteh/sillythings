/**
 * Color header, containing declarations.
 * This is the "header file."
 * 
 * Copyright (c) 2020, Sekhar Ravinutala.
 */


class Color {
  // no touchey these except in member functions
 private:
  double _r, _g, _b;  // Note the underscore in names
  double _fix(double);  // Helper function

 // Member functions defined outside, separately, can be called by anything
 public:
  // Constructor, parameter names are optional
  Color(double, double, double);

  // Mutators (AKA setters)
  void setR(double);
  void setG(double);
  void setB(double);

  // Utility, potentially for debugging
  void dump(const char *);

  // this is overloaded beacuse it has two functions doing the same thing
  // IS THAT WHAT OVERLOADING MEANS!
  // Operator overloading
  Color operator+(const Color &) const;
  bool operator==(const Color &) const;
};

// SAME CONCEPT HERE, LOTS OF VALUES GOING INSIDE THE SAME FUNCTION TWICE

 // Overloading
 double value(double);
 double value(double, double, double);