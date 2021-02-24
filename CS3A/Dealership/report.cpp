/**
 * Generate report for an integration test.
 *
 * Copyright (c) 2019, Sekhar Ravinutala.
 */

#include <algorithm>
#include <utility>
#include <numeric>
#include <cmath>
#include <iomanip>
#include <iostream>
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

  // Wait time stats.

  //  Step 1: Mean
  int count = waits.size();
  uint32_t sum = 0;
  for ( int i = 0; i < waits.size(); i++ ) {
    sum += waits[i];
  }
  double mean = (double)sum / (double)count;

  //  Step 2: Median
  double median;
  if ( count % 2 == 1 ) 
  {
    median = waits[ count / 2 ];
  } 

  else 
  {
    median = ( waits[ count / 2 - 1 ] + waits[ count / 2 ] ) / 2.0;
  }

  //  Step 3: Standard Deviation
  double variance = 0.0, stdDeviation;
  for ( int i = 0; i < waits.size(); i++ ) 
  {
    variance += pow(waits[i] - mean, 2);
  }
  variance = (double)variance / (double)count;
  stdDeviation = sqrt(variance);

  std::cout << std::fixed << std::setprecision(2);
  std::cout << "------------------------------------------------" << std::endl;
  std::cout << "Metrics for the Customer Wait Times (in Minutes)" << std::endl;
  std::cout << "------------------------------------------------" << std::endl;
  std::cout << "Mean               = " << mean / 60.0         << " min" << std::endl;
  std::cout << "Median             = " << median / 60.0       << " min" << std::endl;
  std::cout << "Standard deviation = " << stdDeviation / 60.0 << " min" << std::endl;

  // Agent stats.
  std::vector<Agent> agents = dealer.agents();

  int n = agents.size();
  int index[n];
  for ( int i = 0; i < n; i++ ) 
  {
    index[i] = i;
  }
  
  //formatting for the agent info
  std::cout << "\n";
  std::cout << "-------------------------" << "\n";
  std::cout << "Performance of the Agents" << "\n";
  std::cout << "-------------------------" << "\n";
  std::cout << std::setw( 15 ) << "Agent"        << " "
            << std::setw( 15 ) << "Deals closed" << " "
            << std::setw( 15 ) << "Revenue"      << " "
            << std::setw( 15 ) << "Commission"   << " "
            << std::setw( 15 ) << "Bonus"        << " "
            << "\n";

  std::cout << std::setfill( '-' ) << std::setw( 15 ) << "" << " "
            << std::setfill( '-' ) << std::setw( 15 ) << "" << " "
            << std::setfill( '-' ) << std::setw( 15 ) << "" << " "
            << std::setfill( '-' ) << std::setw( 15 ) << "" << " "
            << std::setfill( '-' ) << std::setw( 15 ) << "" << " "
            << "\n";

  //if this isnt included then youll have dashes next to the numbers rather then blanks
  std::cout << std::setfill( ' ' );


/*
prints out the information for the agents though most
parts have quirks that still need to be ironed out
and redone more smoothly
*/

  for ( int i = 0; i < n; i++ ) 
  {
    int j = index[i];
    std::cout << std::setw( 15 ) << agents[j].info.agentId << " "
            << std::setw( 15 ) << agents[j].closes() << " "
            << std::setw( 15 ) << agents[j].revenue() << " "
            << std::endl;            
  }
}
