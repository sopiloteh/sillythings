/******************************************************************************
CS003B Java
Erick Bravo
07/01/20
P7.03 Random Die Toss
*******************************************************************************/
import java.util.Random;

public class Toss 
{

    public static void main(String[] args)
    {
        // declaring ints
        int[] rans = new int[20];       // to account for 20 runs
        int run = 1;                    // to start the run off
        int actual = rans[0];           // sets the ran array at 0
        int prev = rans[0];             // sets its at a new array after a run
        int current = 1;                // starts it off at current run
        Random rnd = new Random();      // runs a random amount
        
        for (int i = 0; i <20; i++)     //loop to go thru 20 random runs
        {
            int one = rnd.nextInt(6)+1; // rolls a dice
            rans[i] = one;
            System.out.print(one+" ");  //prints out the random numbers
        }
        
        for (int i = 1; i <20; i++)     // adds to the run list up to 20
        {
            if (prev == rans[i])
            {
                current++;
            }
            
            else
            {
                if (run < current)     
                {
                    run = current;
                    actual = prev;
                }
                
                current = 1;
                prev = rans[i];
            }
        }
        
        System.out.println("\nLongest run: "+run);  // prints out the longest
        System.out.println("Value: "+actual);       // value added fun
    }
}
/*
6 1 5 6 5 3 3 5 2 2 5 3 5 5 5 2 1 2 4 5 
Longest run: 3
Value: 5
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  0.866 s
Finished at: 2020-07-03T12:36:01-07:00
------------------------------------------------------------------------
*/
