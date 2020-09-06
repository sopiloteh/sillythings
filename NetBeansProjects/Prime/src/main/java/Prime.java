/******************************************************************************
CS003B Java
Erick Bravo
07/15/20
P10.3 Prime Time
*******************************************************************************/

import java.util.*;

// imported worked example?
interface Sequence
{
    void displayPrimeNumbers();
}

public class Prime 
{

    // checks for non prime nums, also variable
    boolean pnum = false;
    
    public void displayPrimeNumbers()
    {
        //allows user to set a number to look for prime numbers until
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a range\n");
        
        // range holder
        int num = Integer.parseInt(scan.next());
        
        System.out.print("List of Primes below\n");
            
        // searches for prime numbers by dividing by 2
        for (int n = 2; n <= num; n++)
        {
            for (int div = 2; div < n; div++)
            {
                // if no remainder, not a prime
                if (n%div == 0)
                {
                    pnum = false;
                    break;
                }
                
                // prime number
                pnum = true;
            }
            
            //printed out prime number
            if (pnum)
            {
                System.out.print(n+" ");
            }
        }
    }
    
    //starts the sequence
    public static void main(String[] args)
    {
        Prime sequence = new Prime();
       sequence.displayPrimeNumbers();
    }
}

/*
enter a range

67
List of Primes below
3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  6.071 s
Finished at: 2020-07-15T14:56:21-07:00
------------------------------------------------------------------------
*/
