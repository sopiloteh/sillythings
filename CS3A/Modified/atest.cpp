#include <cstdio>
#include <iostream>

using namespace std;

int main()
{
    int matrix[][3] = {{-2,44,200},{10,1,123}}; 

    for (int i = 0; i <2; ++i)
    {
        for (int j = 0; j < 3; ++j)
        {
            cout << matrix[i][j] << endl;
        }
    }
}