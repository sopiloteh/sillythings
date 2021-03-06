class mystring
{
   private:
      char *str;
      int size;
   public:
//default constructor
   mystring()
   {
      size=20;
      str=new char[size];
   }
//--------------
//parameterized constructor
   mystring(const char s[])
   {
      int l=0;
      while(s[l]!='\0')
      l++;
      size=l;
      str=new char[size+1];
      l=-1;
      do
      {
         l++;
         str[l]=s[l];
      }
      while(s[l]!='\0');
   }
//--------------
//copy constructor
   mystring(const mystring &mystr)
   {
      int l=0;
      while(mystr.str[l]!='\0')
         l++;
      size=l;
      str=new char[size+1];
      l=-1;
      do
      {
         l++;
         str[l]=mystr.str[l];
      }
      while(mystr.str[l]!='\0');
}
//--------------
//getting the length of the string
   int length()
   {
      return size;
   }
//--------------
//get the string
   char * getString()
   {
      return str;
   }
//--------------
//set the string
   void setString(const char s[])
   {
      int l=0;
      while(s[l]!='\0')
         l++;
      size=l+1;
      str=new char[size];
   l=-1;
   do
   {
   l++;
   str[l]=s[l];
   }
   while(s[l]!='\0');
   }
   
friend mystring operator+(mystring&, mystring&);
friend void operator<<(mystring&, mystring&);
friend void operator>>(mystring&, mystring&);
friend bool operator>(mystring&, mystring&);
friend bool operator<(mystring&, mystring&);
friend bool operator>=(mystring&, mystring&);
friend bool operator<=(mystring&, mystring&);
friend bool operator==(mystring&, mystring&);
friend bool operator!=(mystring&, mystring&);
};
//--------------
//different operators overloading

//___________