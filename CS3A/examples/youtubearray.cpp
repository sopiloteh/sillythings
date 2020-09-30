#include <iostream>
#include <algorithm> 
using namespace std;

// this will be about arrays

int main()
{
    cout << endl << endl;
    // need to determine a data type
    
    // data type , name , how big , inialized with numbers inside the brackets
    // inside the brackets is array iniazalier list
    // arrays ALWAYS START AT 0, called an element
    int bucky[5] = {11,22,33,44,55};


    // this wont work right away, it cant call the array since it
    // doesnt know where to call it first.
    //cout << bucky << endl;

    // this will work right here, it called the position of it
    cout << bucky[0] << endl;

    // now this will make it as an array using loops

    //using loops now
    int  tom[9];

    cout << "Element - Value" << endl;

    for(int i = 0; i <= 8; i++)
    {
        tom[i] = 99;
        // this just lists the position of i whe it couts in that loop
        //cout << i << endl;

        cout << i << "  -----  " << tom[i] << endl;
    }

    cout << "\n My Attempt \n";

    int test[10];
    cout << "Element - Value" << endl;
    
    for(int j = 10; j >= 9; --j)
    {
        test[j] = 1;
        cout << j << "  -----  " << test[j] << endl;
        //--j;
    }

    cout << "\n Websites version \n";

        // Get the array 
    int arr[] = { 1, 45, 54, 71, 76, 12 }; 
  
    // Compute the sizes 
    int n = sizeof(arr) / sizeof(arr[0]); 
  
    // Print the array 
    
    cout << "Array: \n"; 
    cout << "Element - Value" << endl;
    for (int k = 0; k < n; k++)
    {
        cout << k << "  -----  " << arr[k] << endl;
        //cout << arr[k] << " ";
    } 
         
  
    // Reverse the array 
    reverse(arr, arr + n); 
  
    // Print the reversed array 
    
    cout << "\nReversed Array: \n"; 
    cout << "Element - Value" << endl;
    for (int l = 0; l < n; l++)
    {
        cout << l << "  -----  " << arr[l] << endl;
        //cout << arr[l] << " ";
    } 
        
    max();
    cout << endl << endl;
}
