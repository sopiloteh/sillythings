/******************************************************************************
CS003B Java
Erick Bravo
07/06/20
P8.01 Combo Lock
*******************************************************************************/

import java.util.*;

public class comboTest 
{
    public static void main(String[] args)
    {
        // this allows any code to be inputted
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Combo: ");
        
        // this sets the user inputted code to the variables
        int secretA = sc.nextInt();
        int secretB = sc.nextInt();
        int secretC = sc.nextInt();
        
        // this floods in the function with the inputted variables
        comboLock lock = new comboLock(secretA, secretB, secretC);
        
        // c1 is a counter for inputted variables, more then 3 and it closes
        int c1 = 0;
        
        // the lock starts off closed
        boolean opened = false;
        
        // the lock will always turn right at first
        boolean turningRight = true;
        
        // while its not opened
        while(!opened)
        {
            // while it turns right for the first time
            if (turningRight)
            {
                // allows the input for a right turn 
                System.out.println("Right: ");
                int ticks = sc.nextInt();
                lock.turnRight(ticks);
               
            }
            
            else
            {
                // allows the input for a left turn 
                System.out.println("Left: ");
                int ticks = sc.nextInt();
                lock.turnLeft(ticks);
                
            }
            /*
            if(turningRight)
            {
                lock.turnRight(ticks);
            }
            else
            {
               lock.turnLeft(ticks); 
            }
            */
            
            // while the lock is still locked
            turningRight =! turningRight;
            opened = lock.open();
            
            // if too many inputs it locks
            if (c1 >= 2)
            {
                System.out.println("Lock Locked!");
                return;
                
            }
            c1++;
            
        }
        
        // if all inputs are correct this prints
        System.out.println("Lock UnLocked!");
        
        //resets the lock
        lock.reset();
    }
    
}

/*
Enter Combo: 
1
2
3
Right: 
1
Left: 
2
Right: 
3
Lock Locked!
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  5.648 s
Finished at: 2020-07-07T16:34:22-07:00
------------------------------------------------------------------------
*/
