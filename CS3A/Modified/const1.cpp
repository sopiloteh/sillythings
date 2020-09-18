#include <cstdio>

int main() {
  const char *a = "foo";
  printf("%s\n", a);

  // OK because a is writable
  a = "bar";
  printf("%s\n", a);

  // Not OK because *a is declared as const char
  // *a = 'b';
}