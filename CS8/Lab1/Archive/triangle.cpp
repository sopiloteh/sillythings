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
#include "triangle.h"

/****************************************************************
 * Triangle
 *      This function receives the triangle data and check the
 *      size of the triangle and let then equal to character border
 *      and character fill.
 ****************************************************************/
Triangle::Triangle(int s, char b, char f)
{
  if (s < 1)                    //CHECK - If the length of triangle is less than 1.
  {
    s = 1;                      //SET - The size of triangle equal to 1.
  }

  if (s > 39)                   //CHECK - If the length of triangle is greater than 39.
  {
    s = 39;                     //SET - The size of triangle equal to 39.
  }

  if ( b < 33 || b > 126)       //CHECK - If the border of triangle is less than 33 or
  {                             //          greater than 126.
    b = '#';                    //SET - Border equal to #.
  }

  if (f < 33 || f > 126)        //CHECK - If the fill of triangle is less than 33 or
  {                             //          greater than 126.
    f = '*';                    //SET - Fill equal to *.
  }

  //Pass the value to the variable.
  size = s;
  border = b;
  fill = f;
}
/***********************************************
 * getSize
 *      This function will return the size of
 *      triangle as an integer.
 ***********************************************/
int Triangle::getSize()
{
  return size;
}
/***********************************************
 * Perimeter
 *      This function will return the perimeter
 *      of the triangle.
 ***********************************************/
int Triangle::perimeter()
{
  return 3*size;
}
/***********************************************
 * area
 *  This function will return the area of the
 *  triangle.
 ***********************************************/
double Triangle::area()
{
  return sqrt(3)*size*size/4;
}
/***********************************************
 * grow
 *  This function will add 1 to the size if the
 *  original size is less than 39.
 ***********************************************/
void Triangle::grow()
{
  if (size < 39)
  {
    size += 1;
  }
}
/************************************************
 * shrink
 *  This function will minus 1 to the size if the
 *  original size is greater than 1.
 ************************************************/
void Triangle::shrink()
{
  if (size > 1)
  {
    size -= 1;
  }
}
/*************************************************
 * setBorder
 *      This function will check the border of the
 *      triangle.
 *************************************************/
void Triangle::setBorder(char b)
{
  if (b < 33 || b > 126)        //CHECK - If the border of triangle is less than 33
  {                             //          or greater than 126.
    b = '#';                    //SET - Border equal to #.
  }
  border = b;                   //Pass the value to border.
}
/*************************************************
 * setFill
 *      This function will check the fill of the
 *      triangle.
 *************************************************/
void Triangle::setFill(char f)
{
  if (f < 33 || f > 126)        //CHECK - If the fill of triangle is less than 33
  {                             //          or greater than 126.
    f = '*';                    //SET - Fill equal to *.
  }
  fill = f;                     //Pass the value to fill.
}
/*************************************************
 * draw
 *  This funtion will receives the value from
 *  variable and draw out the picture.
 *************************************************/
void Triangle::draw()
{
  if (size == 1)
  {
    std::cout << border << std::endl;
    return;
  }

  int space = (size)-1;
  int inside = 0;

  //PROC - This will output the top border of the triangle.
  for (int i = 0; i < space; ++i)
  {
    std::cout << " ";
  }
  std::cout << border << std::endl;
  --space;

  //PROC - This will output the border on both sides of the
  //        triangle and triangle fill.
  for (int i = 2; i < size; ++i)
  {
    for (int j = 0; j < space; ++j)
    {
      std::cout << " ";
    }
    --space;
    std::cout << border;

    for(int j = 0; j < inside; ++j)
    {
      std::cout << " " << fill;
    }
    ++inside;
    std::cout << " " << border << std::endl;
  }

  //PROC - This will output the bottom border of the triangle.
  for (int i = 1; i < size; ++i)
  {
    std::cout << border << " ";
  }
  std::cout << border << std::endl;
}
/*********************************************
 * summary
 *      This function receives those value from
 *      other function and print out.
 *********************************************/
void Triangle::summary()
{
  std::cout << "Size of triangle side = " << size << " units \n";
  std::cout << "Perimeter of triangle = " << perimeter() << " units \n";
  printf("Area of triangle = %.21f units\n", area());
  std::cout << "Triangle looks like this: \n";
  draw();
}
