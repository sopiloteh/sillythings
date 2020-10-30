/**
 * Generate report for an integration test.
 *
 * Copyright (c) 2019, Sekhar Ravinutala.
 */

#include <algorithm>
#include <vector>
#include <cstdio>
#include "data/data.h"
#include "match/match.h"

int main() {
  std::vector<Profile> up = profiles(10);
  for (auto p : up) {
    printf("%d, %d: %f, %d: %f, %d: %f, %d: %f, %d: %f, %d: %f\n",
      p.id,
      std::get<0>(p.country), std::get<1>(p.country),
      std::get<0>(p.diet), std::get<1>(p.diet),
      std::get<0>(p.drinking), std::get<1>(p.drinking),
      p.gender, 0.0,
      std::get<0>(p.language), std::get<1>(p.language),
      std::get<0>(p.religion), std::get<1>(p.religion),
      std::get<0>(p.smoking), std::get<1>(p.smoking));
  }
}
