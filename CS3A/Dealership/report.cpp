/**
 * Generate report for an integration test.
 *
 * Copyright (c) 2019, Sekhar Ravinutala.
 */

#include <algorithm>
#include <numeric>
#include <cmath>
#include "data/data.h"
#include "dealer/dealer.h"

#define COMMISSION 10000.0
#define BONUS 100000.0

int main() {
  Dealer dealer(agentInfos(5));
  std::vector<uint32_t> waits;

  for (CustomerInfo &ci : customerInfos(100)) {
    waits.push_back(dealer.assign(ci));
  }
  std::sort(waits.begin(), waits.end());

  // Wait time stats.

  // Agent stats.
}
