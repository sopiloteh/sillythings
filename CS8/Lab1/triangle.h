/********************************************************
 * AUTHOR   : Juan Leon
 * Lab #1   : Template
 * CLASS    : CS 008
 * SECTION  : MW : 6:30p - 8:35p
 * Due Date : 2/19/21
 * ******************************************************/

#include <iostream>
#include <cmath>

/********************************************************
 *
 *
 * Triangle Class
 *
 * ______________________________________________________
 * This program will output the image of the triangle and
 * the perimeter and area of the triangle according to the
 * size, border and fill.
 *_______________________________________________________
 * INPUT:
 *  t1: size,border and fill character of triangle 1 that is given.
 *  t2: size,border and fill character of triangle 2 that is given.
 *  t3: size,border and fill character of triangle 3 that is given.
 *  t4: size,border and fill character of triangle 4 that is given.
 *  
 * OUTPUT
 *  The size,image, perimeter and area of triangles
 *
 ********************************************************/

class Triangle{
  private:
    int size;                   //INPUT - The length of triangle.
    char border,fill;           //INPUT - The border and fill of triangles.

  public:
    int getSize();
    int perimeter();
    double area();
    Triangle(int s = 0, char b = 0, char f = 0);
    void grow();
    void shrink();
    void setBorder(char border);
    void setFill(char fill);
    void draw();
    void summary();
};

