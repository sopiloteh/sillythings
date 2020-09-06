/******************************************************************************
CS003B Java
Erick Bravo
06/25/20
P5.13 Number Discard
*******************************************************************************/

// to allow people to input
import java.util.Scanner;

public class ATMcard 
{
    public static void main(String args[])
    {
        // this is to let the user input something
        Scanner atm = new Scanner(System.in);
        System.out.println("Please input your ultra secure ATM code: \n"
                + "Four digit max please (ex: 1234)");
        int code = atm.nextInt();
        
        // this is to all true or false statements
        boolean test = true;
        
        if (code == 1234)
        {
            // once the pin is correct this prints out
            System.out.println("Your PIN is correct");
            // this tells the program to stop running the rest
            test = false;
        }
        
        if (code != 1234)
        {
            // prints out if its false
            System.out.println("Your PIN is incorrect");
            // this tells the program to keep running the rest
            test = true;
        }
        
        if (test = true)
        {
            // has the program enter in the code again
            System.out.println("Enter Pin number again: ");
            code = atm.nextInt();
        }
        
        if (code == 1234)
        {
            System.out.println("Your PIN is correct");
            // this tells the program to stop running the rest
            test = false;
        }
        
        if (test == true)
        {
            // has the program enter in the code again
            System.out.println("Enter Pin number again: ");
            code = atm.nextInt(); 
        }
        
        if (code == 1234)
        {
            System.out.println("Your PIN is correct");
        }
        
        else
        {
            // only runs if no more true booleans appear
            System.out.println("Your debit card is declined, BLOCKED!");
        }
            
    }
    
}
/*
Please input your ultra secure ATM code: 
Four digit max please (ex: 1234)
1222
Your PIN is incorrect
Enter Pin number again: 
1233
Enter Pin number again: 
1234
Your PIN is correct
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  9.736 s
Finished at: 2020-06-25T19:16:35-07:00
------------------------------------------------------------------------

Please input your ultra secure ATM code: 
Four digit max please (ex: 1234)
1222
Your PIN is incorrect
Enter Pin number again: 
1222
Enter Pin number again: 
1222
Your debit card is declined, BLOCKED!
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  6.156 s
Finished at: 2020-06-25T19:16:56-07:00
------------------------------------------------------------------------
*/
