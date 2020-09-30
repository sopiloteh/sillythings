#include <cstdio>

int main() {
  // this constat will always be printed since it is a const, it never ever changes
  // this is beacuse * <- is placing in memory foo which will always stay like that for this program1ret 
  const char *a = "foo";
  printf("%s\n", a);

  // OK because a is writable
  a = "bar";
  printf("%s\n", a);

  // Not OK because *a is declared as const char
  // *a = 'b';
}