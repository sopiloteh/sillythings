/**
 * Original Dating Sim
 *
 * Copyright (c) 2020, Erick Bravo
 */

#include "match/match.h"

std::map<uint32_t, uint32_t> Match::pairs(std::vector<Profile>& profs)
{
  //variables
  double maxScore; // best compatible score
  int calc; // placeholder
  double current; // the most up to date score for the weighings

  //creates a new map called m to hold the sorting pairs
  std::map<uint32_t, uint32_t> m;

  // for loop to go through the sorting size
  for (size_t i = 0; i < profs.size(); i++)
   {
	// checks to see if the gender is not a male
    if (profs[i].gender != MALE) 
	{
	 continue;
	}
	
	// starts off at -1 so that the pairs start (0,1)(2,3)(4,5) etc
	maxScore = -1;
	calc = -1;

	//sorting logic to compare weights	
	for (size_t j = 0; j < profs.size(); j++)
	 {
	  if (i != j) 
	  {
	   current = 0;
		if (profs[i].gender != profs[j].gender) 
		{
		 if (std::get<0>(profs[i].country) == std::get<0>(profs[j].country)) 
		 {
		 current += std::get<1>(profs[i].country) + std::get<1>(profs[j].country);
		 }

		 if (std::get<0>(profs[i].diet) == std::get<0>(profs[j].diet)) 
		 {
		 current += std::get<1>(profs[i].diet) + std::get<1>(profs[j].diet);
		 }
					
		 if (std::get<0>(profs[i].drinking) == std::get<0>(profs[j].drinking)) 
		 {
		 current += std::get<1>(profs[i].drinking) + std::get<1>(profs[j].drinking);
		 }
					
		 if (std::get<0>(profs[i].language) == std::get<0>(profs[j].language)) 
		 {
		 current += std::get<1>(profs[i].language) + std::get<1>(profs[j].language);
		 }
		 
		 if (std::get<0>(profs[i].smoking) == std::get<0>(profs[j].smoking)) 
		 {
		 current += std::get<1>(profs[i].smoking) + std::get<1>(profs[j].smoking);
		 }
					
		 if (std::get<0>(profs[i].religion) == std::get<0>(profs[j].religion)) 
		 {
		 current += std::get<1>(profs[i].religion) + std::get<1>(profs[j].religion);
		 }
		 
		 // takes the current top pairing and puts it into the max score which then puts it into "calc"
		 if (current > maxScore) 
		 {
		 maxScore = current;
		 calc = j;
		 }
		}
	 }
	}
	
	// puts the sorted "calc" value into the "m" map
	if (calc != -1) 
	{
	 m[profs[i].id] = profs[calc].id;
	}
   }

	// sends it back to report
	return m;
}
