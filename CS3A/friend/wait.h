#include <iostream>
#include <iterator>


namespace fruit
{
  enum fruit
  {
    pear,
    cherry,
    grape,
    melon,
    lemon,
    lime,
    avacado,
    blueberry,
    strawberry,
    fig,
    maxFruit
    };
}

class apple
{
  private:
    double orange[];
  public:
    void showFruit(double orange[fruit::maxFruit]);
    void sortFruit();
};

void apple::showFruit(double orange[fruit::maxFruit])
{
  double s;
  s = orange.size[fruit::maxFruit];
  std::cout << " This will show us all them fruits:\n"
  << s << std::endl;
}

void apple::sortFruit()
{
  std::cout << "test of string obvi\n";
}