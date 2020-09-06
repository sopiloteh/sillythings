/******************************************************************************
CS003B Java
Erick Bravo
06/25/20
P4.3 Number Discard
*******************************************************************************/

import java.util.Scanner;

public class numDiscard 
{
    public static void main(String args[])
    {
        // this is to let the user input something
        Scanner sc = new Scanner(System.in);
        System.out.println("Input: ");
        
        // this stores in the number
        int num = sc.nextInt() %1000;
        int rev = 0;
        int help = num;
        
        // as long as the number is bigger then zero
        while (help > 0)
        {
            // multiply then add
            rev = rev * 10 + help%10;
            help = help / 10;
        }
        
        System.out.println("Reversed: " + rev);
        
        // find the difference 
        int diff = num - rev;
        System.out.println("Difference: "+ diff);
        
        int revv = 0;
        help = diff;
        
        while (help > 0)
        {
            revv = revv * 10 + help %10;
            help = help /10;
        }
        
        System.out.println("Reversed: " + revv);
        
        // adds them together to get 1089(usually)
        System.out.println("Sum: "+(revv+diff));        
    }
}

/*
Input: 
4123412
Reversed: 214
Difference: 198
Reversed: 891
Sum: 1089
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  3.525 s
Finished at: 2020-06-25T15:50:28-07:00
------------------------------------------------------------------------
*/
