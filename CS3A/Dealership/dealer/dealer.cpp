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
  
  uint8_t maxExpertise = 0;
  double maxRating = 0;
  time_t minWaitTime = std::numeric_limits<time_t>::max();

  uint8_t agent_expertise;
  double agent_rating;
  time_t agent_waitTime;

  Agent *target = NULL;

  for (std::vector<Agent>::iterator it = _agents.begin() ; it != _agents.end(); ++it) 
  {
    agent_expertise = (*it).info.expertise.at( cInfo.interest );
    agent_rating = (*it).info.rating;

    if ( agent_expertise > maxExpertise ) 
    {
      maxExpertise = agent_expertise;
      maxRating = agent_rating;
      target = &*it;
    } 
    
    else if ( agent_expertise == maxExpertise ) 
    {
      if ( agent_rating > maxRating ) 
      {
        maxExpertise = agent_expertise;
        maxRating = agent_rating;
        target = &*it;
      }
    }
  }

  if ( target == NULL ) 
  {
    for (std::vector<Agent>::iterator it = _agents.begin() ; it != _agents.end(); ++it) 
    {
      agent_waitTime = (*it).when() - cInfo.arrivalTime;

      if ( agent_waitTime < minWaitTime ) 
      {
        minWaitTime = agent_waitTime;
        target = &*it;
      }
    }
  }
  return target->assign( cInfo );
}

const std::vector<Agent> Dealer::agents() {
  return _agents;
}
