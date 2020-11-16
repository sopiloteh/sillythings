/**
 * Dealer declarations.
 *
 * Copyright (c) 2019, Sekhar Ravinutala.
 */

#ifndef DEALER_DEALER_H_
#define DEALER_DEALER_H_

#include <vector>
#include "data/data.h"
#include "dealer/agent.h"

class Dealer {
 private:
  std::vector<Agent> _agents;

 public:
  explicit Dealer(const std::vector<AgentInfo> &);
  uint32_t assign(const CustomerInfo &);
  const std::vector<Agent> agents();
};

#endif  // DEALER_DEALER_H_
