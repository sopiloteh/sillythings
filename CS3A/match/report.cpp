/**
 * Original Dating Sim
 *
 * Copyright (c) 2020, Erick Bravo
 */

#include <algorithm>
#include <vector>
#include <cstdio>
#include "data/data.h"
#include "match/match.h"

int main() 
{
	std::vector<Profile> up = profiles(100);
	// for (auto p : up) {
	// 	printf("%d, %d: %f, %d: %f, %d: %f, %d: %f, %d: %f, %d: %f\n",
	// 		p.id,
	// 		std::get<0>(p.country), std::get<1>(p.country),
	// 		std::get<0>(p.diet), std::get<1>(p.diet),
	// 		std::get<0>(p.drinking), std::get<1>(p.drinking),
	// 		p.gender, 0.0,
	// 		std::get<0>(p.language), std::get<1>(p.language),
	// 		std::get<0>(p.religion), std::get<1>(p.religion),
	// 		std::get<0>(p.smoking), std::get<1>(p.smoking));
	// }

	// map that pulls in from pairs 
	std::map<uint32_t, uint32_t> m = Match::pairs(up);

	// goes over the new map to print it out
	std::map<uint32_t, uint32_t>::iterator it = m.begin();

	// prints out the sorted pairings, only male and female
	printf("Sorted pairings\nMale : Female\n");
	while (it != m.end()) 
	{
	  printf("%u %u\n", it->first, it->second);
	  it++;
	}
}