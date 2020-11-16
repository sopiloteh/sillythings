/**
 * Agent declarations.
 *
 * Copyright (c) 2019, Sekhar Ravinutala.
 */

#ifndef DEALER_AGENT_H_
#define DEALER_AGENT_H_

#include <cstdint>
#include "data/data.h"

class Agent {
 private:
  uint32_t _closes = 0;
  double _revenue = 0;
  uint16_t _bonuses = 0;
  std::time_t _when = 0;
  std::time_t _sunday = 0;
  uint32_t _weekCloses = 0;

 public:
  const AgentInfo info;
  explicit Agent(const AgentInfo &);
  uint32_t closes();
  double revenue();
  uint16_t bonuses();
  std::time_t when();
  uint32_t assign(const CustomerInfo &);
};

#endif  // DEALER_AGENT_H_
