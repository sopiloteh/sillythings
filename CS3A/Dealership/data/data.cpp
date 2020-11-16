/**
 * Generate test data.
 *
 * Copyright (c) 2019, Sekhar Ravinutala.
 */

#include <cstdint>
#include "data/data.h"

std::map<CarKind, double> PRICES = {
  {FERRARI, 256550},
  {LAMBORGHINI, 203295},
  {MCLAREN, 288845},
  {PORSCHE, 294250}
};

int rnd() {
  int value;
  scanf("%d", &value);
  return value;
}

std::time_t update(std::time_t time, uint32_t inc, bool sunday) {
  /**
   * Increment time, reset to opening time if inc = 0.
   * - time: Time in seconds since epoch.
   * - inc: Increment in seconds.
   * - sunday: Reset to Sunday.
   */
  time += inc;
  std::tm *tm = std::localtime(&time);
  if (tm->tm_hour >= CLOSE) {
    tm->tm_mday++;
    tm->tm_wday++;
  }
  if (tm->tm_hour >= CLOSE || inc == 0) {
      tm->tm_hour = OPEN;
      tm->tm_min = tm->tm_sec = 0;
  }
  if (sunday) {
    tm->tm_mday += 7 - tm->tm_wday;
  }
  return std::mktime(tm);
}

std::vector<AgentInfo> agentInfos(uint16_t count) {
  std::vector<AgentInfo> av;

  for (uint16_t i = 0; i < count; ++i) {
    av.push_back({
      rnd() % 900000 + 100000,
      []() {
        std::map<CarKind, uint8_t> expertise;
        for (auto c : PRICES) {
          expertise[c.first] = rnd() % PRICES.size();
        }
        return expertise;
      }(),
      static_cast<uint8_t>(rnd() % 3 + 3),
      static_cast<double>(rnd()) / RAND_MAX
    });
  }
  return av;
}

std::vector<CustomerInfo> customerInfos(uint16_t count) {
  std::vector<CustomerInfo> cv;

  // Start with today, randomly schedule every two hours.
  time_t next = update(std::time(NULL), 0);
  for (uint16_t i = 0; i < count; ++i) {
    cv.push_back({
      next = update(next, rnd() % (80 * 60)),
      static_cast<CarKind>(rnd() % PRICES.size()),
      rnd() > 0.2 * RAND_MAX
    });
  }
  return cv;
}
