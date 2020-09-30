#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <cassert>
using namespace std;

class Student 
{
    // these variables dont change or arent touched
  private:
    // how many scores
    int scores[5];
    // this is the sum of the scores to see whos the bigges
    int sum;
    
  public:
    // these can change!
    Student() : sum(0) {}

    // sum is a blank array
    // this function shoots out from the class into mainn
    int calculateTotalScore() 
        {
        return sum;
        }

    // this adds up the scores to an array which is a private interval
    // after each time it starts up againn, the array is blank, it is not overwritten since nothingn is there to be overwritten
    void input() 
    {
        for(int i=0; i<5; i++) {
            cin >> scores[i];
            sum+=scores[i];
        }
    }
};

int main() {
    int n; // number of students
    cin >> n;
    Student *s = new Student[n]; // an array of n students
    
    for(int i = 0; i < n; i++){
        s[i].input();
    }

    // calculate kristen's score
    int kristen_score = s[0].calculateTotalScore();

    // determine how many students scored higher than kristen
    int count = 0; 
    for(int i = 1; i < n; i++){
        int total = s[i].calculateTotalScore();
        if(total > kristen_score){
            count++;
        }
    }

    // print result
    cout << count << endl;
    
    return 0;
}



