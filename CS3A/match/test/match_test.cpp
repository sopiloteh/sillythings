/**
 * Original Dating Sim
 *
 * Copyright (c) 2020, Erick Bravo
 */

#include "gtest/gtest.h"
#include "data/data.h"
#include "match/match.h"

TEST(testMatch,myMatchTest)
{
  EXPECT_THAT(100, Match::pairs(std::vector<Profile>));
  
  // test to see if there are pairings
  
  //EXPECT_EQ();
  //EXPECT_FALSE();
}

TEST(data,profile)
{
  Profile profile;
  // test to see if vectors are filled

}

// TEST(match,report)
// {
//   // checks to see if it prints something
//   EXPECT_EQ();
//   EXPECT_FALSE();
// }
