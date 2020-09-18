#include <cstdio>
#include <iostream>

/**
 * OK, only works for string; use if only a few
 * using std::string;
 * 
 * Not OK because then all names in std are then off limits
 * using namespace std;
 * 
 * Best
 * Refer with std::string, etc.
 */

// Implements informational cohesion
struct Student {
  // Member variables AKA attributes (data part of cohesion)
  int id;
  const char *lastName;
  const char *firstName;
  

  // Member functions AKA methods (operations part of cohesion)
  void dump()
    {
    //std::cout << id <<","<< firstName <<","<< lastName <<"\n\n\n\n";
    printf("%-8d%s %s\n", id, firstName, lastName);
    }
};

/**
 * s1, s2 are "instances" of the "type" struct Student.
 * You can have any number of instances for one type.
 */
int main() {
  // Method 1 to initialize
  Student s1 = {54213, "Jimmy", "Fallon"};
  s1.dump();
  Student s2 = {69420, "Homer", "Simpson"};
  s2.dump();

  /*
  // Method 2, initializing using dot notation
  Student s2;
  s2.id = 332786;
  s2.firstName = "Lisa";
  s2.lastName = "Connolly";
  s2.dump();

  // Pointer to struct, access using arrow notation
  Student *s2p = &s2;
  s2p->lastName = "Page";
  s2.dump();
  */
}
