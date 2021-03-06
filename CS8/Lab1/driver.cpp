/*
Lab 01
Erick Bravo & Xinming Fu
Data Structures
Feb 17th 2021
*/

#include "triangle.h"

using namespace std;

int main() 
{
  // create some Triangles
  Triangle t1( -5 ), t2( 7, '^' ), t3( 12, 'X', 'O' ), t4( 50 , '$' , 'o');
  // display original Triangles

  cout << "t1 has size = " << t1.getSize() << " units.\n";
  t1.draw();
  cout << "\nt2 has size = " << t2.getSize() << " units.\n";
  t2.draw();
  cout << "\nt3 has size = " << t3.getSize() << " units.\n";
  t3.draw();
  cout << "\nt4 has size = " << t4.getSize() << " units.\n";
  t4.draw();
  cout << '\n';

  t1.shrink(); // demonstrate shrink
  t2.shrink();
  t3.grow(); // and grow
  t4.grow();
  cout << "t1 now has size = " << t1.getSize() << " units.\n";
  cout << "t2 now has size = " << t2.getSize() << " units.\n";
  cout << "t3 now has size = " << t3.getSize() << " units.\n";
  cout << "t4 now has size = " << t4.getSize() << " units.\n";

  // demonstrate perimeter
  cout << "t2 has perimeter = " << t2.perimeter() << " units.\n";
  cout << "t3 has perimeter = " << t3.perimeter() << " units.\n";
  // and area
  cout << "t2 has area = " << t2.area() << " square units.\n\n";
  cout << "t3 has area = " << t3.area() << " square units.\n\n";

  t1.draw();
  t1.grow();               // show that fill character
  cout << "t1 grows:\n";   // appears only when size
  t1.draw();               // is at least 3
  t1.grow();
  cout << "... and grows:\n";
  t1.draw();
  cout << '\n';

  t1 = t2; // demonstrate the default overload of the
  // assignment operator
  cout << "t1 now has size = " << t1.getSize() << " units.\n";
  t1.draw();

  // demonstrate the changing of border and fill characters
  t2.setBorder('@');
  t2.setFill('-');
  cout << "t2 now looks like:\n";
  t2.draw();
  cout << '\n';
  t2.setBorder('\n');	 // illegal border
  t2.setFill('\a');	 // illegal fill
  cout << "t2 now looks like:\n";
  t2.draw();
  cout << '\n';

  cout << "\nHere is a summary on t3:\n"; // demonstrate summary
  t3.summary();

  return 0;
}