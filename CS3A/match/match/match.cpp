#include "match/match.h"

std::map<uint32_t, uint32_t> Match::pairs(std::vector<Profile>& profs)
{
	double maxScore;
	int k;
	double current;
	std::map<uint32_t, uint32_t> m;
	for (size_t i = 0; i < profs.size(); i++)
	{
		if (profs[i].gender != MALE) {
			continue;
		}
		maxScore = -1;
		k = -1;
		for (size_t j = 0; j < profs.size(); j++)
		{
			if (i != j) {
				current = 0;
				if (profs[i].gender != profs[j].gender) {
					if (std::get<0>(profs[i].country) == std::get<0>(profs[j].country)) {
						current += std::get<1>(profs[i].country) + std::get<1>(profs[j].country);
					}
					if (std::get<0>(profs[i].diet) == std::get<0>(profs[j].diet)) {
						current += std::get<1>(profs[i].diet) + std::get<1>(profs[j].diet);
					}
					if (std::get<0>(profs[i].drinking) == std::get<0>(profs[j].drinking)) {
						current += std::get<1>(profs[i].drinking) + std::get<1>(profs[j].drinking);
					}
					if (std::get<0>(profs[i].language) == std::get<0>(profs[j].language)) {
						current += std::get<1>(profs[i].language) + std::get<1>(profs[j].language);
					}
					if (std::get<0>(profs[i].smoking) == std::get<0>(profs[j].smoking)) {
						current += std::get<1>(profs[i].smoking) + std::get<1>(profs[j].smoking);
					}
					if (std::get<0>(profs[i].religion) == std::get<0>(profs[j].religion)) {
						current += std::get<1>(profs[i].religion) + std::get<1>(profs[j].religion);
					}
					if (current > maxScore) {
						maxScore = current;
						k = j;
					}
				}
			}
		}
		if (k != -1) {
			m[profs[i].id] = profs[k].id;
		}
	}
	return m;
}
