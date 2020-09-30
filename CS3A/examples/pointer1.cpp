#include <cstdio>
#include <iostream>

int add(int a, int b) {
  return a + b;
}

int main() {
  int i1 = 10;
  int i2 = 20;
  printf("i1 = %d, i2 = %d\n", i1, i2);
    std::cout << std::endl;

  int *i1p = &i1;
  printf("i1p = %p, *i1p = %d\n", i1p, *i1p);
    std::cout << std::endl;

  int *i2p = &i2;
  printf("i2p = %p, *i2p = %d\n", i2p, *i2p);
    std::cout << std::endl;

  double d1 = 2.7;
  double *d1p = &d1;
  printf("d1p = %p, *d1p = %.1lf\n", d1p, *d1p);
  std::cout << "d1p = " << d1p << ", *d1p = " << *d1p << std::endl;
    std::cout << std::endl;

  double d2 = -1.6;
  auto d2p = &d2;

  // For illustration only, don't freak out!
  int (*a1)(int, int) = add;
  auto a2 = add;
  std::cout << "i1 + i2 = " << a1(i1, i2) << std::endl;
    std::cout << std::endl;

  // Increases by size of what the pointer looks at
  printf("i2p = %p, i2p + 1 = %p\n", i2p, i2p + 1);
  printf("d2p = %p, d2p + 1 = %p\n", d2p, d2p + 1);
    std::cout << std::endl;

  // Check the equivalence of the two formats
  int ia[] = {100, 200, 300};
  int *ip = ia;
  std::cout << "ia[1] = " << ia[1] << ", *(ip + 1) = " << *(ip + 1)
            << std::endl;
    std::cout << std::endl;
}
