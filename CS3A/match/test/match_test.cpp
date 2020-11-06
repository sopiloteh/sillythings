#include"match/Match.h"
#include<iostream>

void test1() {
    std::vector<Profile> up;
    up.push_back({
          100,
          MALE,
          {CANADA, 1},
          {VEGETARIAN, 1},
          {true, 1},
          {ENGLISH, 1},
          {CHRISTIAN, 1},
          {true, 1}
        });
    up.push_back({
          101,
          FEMALE,
          {CANADA, 1},
          {VEGETARIAN, 1},
          {true, 1},
          {ENGLISH, 1},
          {CHRISTIAN, 1},
          {true, 1}
        });
    up.push_back({
      102,
      FEMALE,
      {CANADA, 0.5},
      {VEGETARIAN, 0.5},
      {true, 0.5},
      {ENGLISH, 0.5},
      {CHRISTIAN, 0.5},
      {true, 0.5}
        });
    std::map<uint32_t, uint32_t> m = Match::pairs(up);
    if (m.size() != 1 && m[100] != 101) {
        printf("test 1 failed\n");
        return;
    }
    printf("Test 1 passed\n");
}

void test2() {
    std::vector<Profile> up;
    up.push_back({
          100,
          MALE,
          {CANADA, 1},
          {VEGETARIAN, 1},
          {true, 1},
          {ENGLISH, 1},
          {CHRISTIAN, 1},
          {true, 1}
        });
    up.push_back({
          101,
          MALE,
          {CANADA, 1},
          {VEGETARIAN, 1},
          {true, 1},
          {ENGLISH, 1},
          {CHRISTIAN, 1},
          {true, 1}
        });
    up.push_back({
      102,
      MALE,
      {CANADA, 0.5},
      {VEGETARIAN, 0.5},
      {true, 0.5},
      {ENGLISH, 0.5},
      {CHRISTIAN, 0.5},
      {true, 0.5}
        });
    std::map<uint32_t, uint32_t> m = Match::pairs(up);
    if (!m.empty()) {
        printf("test 2 failed\n");
        return;
    }
    printf("Test 2 passed\n");
}

void test3() {
    std::vector<Profile> up;
    up.push_back({
          100,
          FEMALE,
          {CANADA, 1},
          {VEGETARIAN, 1},
          {true, 1},
          {ENGLISH, 1},
          {CHRISTIAN, 1},
          {true, 1}
        });
    up.push_back({
          101,
          FEMALE,
          {CANADA, 1},
          {VEGETARIAN, 1},
          {true, 1},
          {ENGLISH, 1},
          {CHRISTIAN, 1},
          {true, 1}
        });
    up.push_back({
      102,
      FEMALE,
      {CANADA, 0.5},
      {VEGETARIAN, 0.5},
      {true, 0.5},
      {ENGLISH, 0.5},
      {CHRISTIAN, 0.5},
      {true, 0.5}
        });
    std::map<uint32_t, uint32_t> m = Match::pairs(up);
    if (!m.empty()) {
        printf("test 3 failed\n");
        return;
    }
    printf("Test 3 passed\n");
}

void test4() {
    std::vector<Profile> up;
    up.push_back({
          100,
          MALE,
          {CANADA, 1},
          {VEGETARIAN, 1},
          {true, 1},
          {ENGLISH, 1},
          {CHRISTIAN, 1},
          {true, 1}
        });
    up.push_back({
          101,
          FEMALE,
          {CANADA, 1},
          {VEGETARIAN, 1},
          {true, 1},
          {ENGLISH, 1},
          {CHRISTIAN, 1},
          {true, 1}
        });
    
    up.push_back({
          102,
          FEMALE,
          {USA, 1},
          {NONVEGETARIAN, 1},
          {false, 1},
          {FRENCH, 1},
          {JEWISH, 1},
          {false, 1}
        });

    std::map<uint32_t, uint32_t> m = Match::pairs(up);
    if (m.size() != 1 && m[100] != 101) {
        printf("test 4 failed\n");
        return;
    }
    printf("Test 4 passed\n");
}


int main() {
	test1();
    test2();
    test3();
    test4();
    return 0;
}
