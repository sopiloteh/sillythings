/**
 * Agent implementation.
 *
 * Copyright (c) 2019, Sekhar Ravinutala.
 */

#include <algorithm>
#include "dealer/agent.h"

Agent::Agent(const AgentInfo &aInfo) : info(aInfo) {
}

uint32_t Agent::closes() {
  return _closes;
}

double Agent::revenue() {
  return _revenue;
}

uint16_t Agent::bonuses() {
  return _bonuses;
}

std::time_t Agent::when() {
    return _when;
}

uint32_t Agent::assign(const CustomerInfo &cInfo) {
  time_t begin = std::max(_when, cInfo.arrivalTime);
  _when = update(begin, info.serviceTime * 3600);

  // Add your code here.

  return (begin - cInfo.arrivalTime) / 60;
}
