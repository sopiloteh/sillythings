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
  if ( cInfo.saleClosed ) 
  {
    _closes++;
    _weekCloses++;
    _revenue += PRICES[ cInfo.interest ];
  }


  std::tm *tm = std::localtime(&begin);
  tm->tm_mday += 7 - tm->tm_wday;
  tm->tm_wday = 0;
  tm->tm_hour = 0;
  tm->tm_min = 0;
  tm->tm_sec = 0;
  _sunday = std::mktime(tm);

  if ( _when > _sunday ) 
  {
    _when = update( _when, 0, true );
    if ( _weekCloses >= 10 ) 
    {
      _bonuses += 100000;
    }
  }

  return (begin - cInfo.arrivalTime) / 60;
}
