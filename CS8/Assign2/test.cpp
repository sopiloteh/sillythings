#include<iostream>
using namespace std;
#include "notstring.h"

int main()
{
  
mystring str1("wel");
mystring str2("come");
mystring str3("look");
mystring str4("look");
  
if(str1>str2)
{
   cout<<str1.getString()<<" is greater than "<<str2.getString()<<endl;
}


else if(str1<str2)
{
   cout<<str1.getString()<<" is less than "<<str2.getString()<<endl;
}


else
{
   cout<<str1.getString()<<" is equal to "<<str2.getString()<<endl;
}

  
if(str3==str4)
{
   cout<<str3.getString()<<" is equal to "<<str4.getString()<<endl;
}

  
return 0;
}