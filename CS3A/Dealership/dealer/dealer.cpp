/**
 * Dealer implementation.
 *
 * Copyright (c) 2019, Sekhar Ravinutala.
 */

#include <algorithm>
#include <cmath>
#include "data/data.h"
#include "dealer/dealer.h"

#define S(a, c) (10 * std::min(c.arrivalTime - a.when(), 0L) +\
  a.info.expertise.at(c.interest) + a.info.rating)

Dealer::Dealer(const std::vector<AgentInfo> &aInfos) {
  for (auto info : aInfos) {
    _agents.push_back(Agent(info));
  }
}

uint32_t Dealer::assign(const CustomerInfo &cInfo) {
  // Add your code here.
}

const std::vector<Agent> Dealer::agents() {
  return _agents;
}
