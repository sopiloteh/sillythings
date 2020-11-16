/**
 * Generate test data.
 *
 * Copyright (c) 2019, Sekhar Ravinutala.
 */

#ifndef DATA_DATA_H_
#define DATA_DATA_H_

#include <cstdint>
#include <ctime>
#include <vector>
#include <map>

enum CarKind {
  FERRARI, LAMBORGHINI, MCLAREN, PORSCHE
};

enum HOURS {
  OPEN = 8, CLOSE = 17
};

struct AgentInfo {
  int agentId;
  std::map<CarKind, uint8_t> expertise;
  uint8_t serviceTime;
  double rating;
};

struct CustomerInfo {
  time_t arrivalTime;
  CarKind interest;
  bool saleClosed;
};

extern std::map<CarKind, double> PRICES;

std::vector<AgentInfo> agentInfos(uint16_t count);
std::vector<CustomerInfo> customerInfos(uint16_t count);

std::time_t update(std::time_t, uint32_t, bool = false);

#endif  // DATA_DATA_H_
