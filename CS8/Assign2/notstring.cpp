#include "notstring.h"


//_____________
//concatrnating two string using
//overloading + operator
mystring operator+(mystring &s1, mystring &s2)
{  
   int size=s1.length()+s2.length()+1;
   mystring mystr;
   mystr.str=new char[size];
   mystr.size=size;
  
   int i=0,j=0;
   while(i<s1.length())
   {
      mystr.str[i]=s1.str[i];
      i++;
   }

   while(j<=s2.length())
   {
      mystr.str[i]=s2.str[j];
   j++;
   i++;
   }

return mystr;
}
//_______________
//overloading << operator
void operator<<(mystring &s1, mystring &s2)
{
   s1.size=s2.length();
   s1.str=new char[s1.size+1];
   for(int i=0;i<=s2.length();i++)
   {
      s1.str[i]=s2.str[i];
   } 
}
//_____________
//overloading >> operator
void operator>>(mystring &s1, mystring &s2)
{
   s2.size=s1.length();
   s2.str=new char[s2.size+1];
   for(int i=0;i<=s1.length();i++)
   {
      s2.str[i]=s1.str[i];
   }
}
//_____________
//overloading > operator
bool operator>(mystring &s1, mystring &s2)
{
   int len1=s1.length();
   int len2=s2.length();
   if (len1<=len2)
   {
      for(int i=0;i<len1;i++)
      {
         if(s1.str[i]>s2.str[i])
            return true;
         else if(s1.str[i]<s2.str[i])
            return false;
      }
   return false;
   }

   else if(len1>len2)
   {
   for(int i=0;i<len2;i++)
   {
      if(s1.str[i]>s2.str[i])
         return true;
      else if(s1.str[i]<s2.str[i])
         return false;
   }
   return true;
   }
}
//_________
//overloading < operator
bool operator<(mystring &s1, mystring &s2)
{
   int len1=s1.length();
   int len2=s2.length();
   if (len1<=len2)
   {
      for(int i=0;i<len1;i++)
      {
         if(s1.str[i]<s2.str[i])
            return true;
         else if(s1.str[i]>s2.str[i])
            return false;
      }
   return false;
   }
   else if(len1>len2)
   {
      for(int i=0;i<len2;i++)
      {
         if(s1.str[i]<s2.str[i])
            return true;
         else if(s1.str[i]>s2.str[i])
            return false;
      }
   return true;
   }
}
//_________
//overloading >= operator
bool operator>=(mystring &s1, mystring &s2)
{
int len1=s1.length();
int len2=s2.length();
   if (len1<=len2)
   {
      for(int i=0;i<len1;i++)
      {
         if(s1.str[i]>=s2.str[i])
            return true;
         else if(s1.str[i]<s2.str[i])
            return false;
      }
   return false;
   }

   else if(len1>len2)
   {
      for(int i=0;i<len2;i++)
      {
         if(s1.str[i]>=s2.str[i])
            return true;
      else if(s1.str[i]<s2.str[i])
            return false;
      }
   return true;
   }
}
//__________
//overloading <= operator
bool operator<=(mystring &s1, mystring &s2)
{
int len1=s1.length();
int len2=s2.length();
   if (len1<=len2)
   {
      for(int i=0;i<len1;i++)
      {
         if(s1.str[i]<=s2.str[i])
            return true;
         else if(s1.str[i]>s2.str[i])
            return false;
      }
   return false;
   }

   else if(len1>len2)
   {
      for(int i=0;i<len2;i++)
      {
         if(s1.str[i]<=s2.str[i])
            return true;
         else if(s1.str[i]>s2.str[i])
            return false;
   }
   return true;
   }
}
//__________
//overloading == operator
bool operator==(mystring &s1, mystring &s2)
{
int len1=s1.length();
int len2=s2.length();
   if (len1<len2)
      return false;
   else if(len1>len2)
      return false;
   else
   {
      for(int i=0;i<len1;i++)
         if(s1.str[i]!=s2.str[i])
            return false;
   }
   return true;
}
//___________
//overloading != operator

bool operator!=(mystring &s1, mystring &s2)
{
int len1=s1.length();
int len2=s2.length();
   if (len1<len2)
      return true;
   else if(len1>len2)
      return true;
   else
   {
      for(int i=0;i<len1;i++)
         if(s1.str[i]!=s2.str[i])
            return true;
   }
   return false;
}