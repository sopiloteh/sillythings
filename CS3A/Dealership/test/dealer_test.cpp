/**
 * Unit tests for dealer.
 *
 * Copyright (c) 2019, Sekhar Ravinutala.
 */

#include <gtest/gtest.h>
#include "data/data.h"
#include "dealer/dealer.h"

const AgentInfo AGENTS[] = {
  {
    223432,
    {
      {FERRARI, 3},
      {LAMBORGHINI, 2},
      {MCLAREN, 2},
      {PORSCHE, 4}
    },
    3,
    0.5
  }
};
const CustomerInfo CUSTOMERS[] = {
  {
    std::time(NULL),
    FERRARI,
    true
  }
};

// Add your code here.
