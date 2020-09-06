/******************************************************************************
CS003B Java
Erick Bravo
07/06/20
P8.01 Combo Lock
*******************************************************************************/

import java.util.*;

public class Lock 
{
    int secretA, secretB, secretC;
    int secA, secB, secC;
    int count = 1;
    boolean open = true;
    
    public Lock(int secretA, int secretB, int secretC)
    {
        this.secretA = secretA;
        this.secretB = secretB;
        this.secretC = secretC;
        System.out.println("This is the built in locker code\n"
                +secretA+", "+secretB+", "+secretC);
    }
    
    public void reset()
    {
        secA = 0;
        secB = 0;
        secC = 0;
        count = 1;
        open = true;
    }
    
    public void turnLeft(int ticks)
    {
        if (count != 0)
        {
            open = false;
        }
        
        else
        {
            secB = ticks;
            count++;
        }
    }
    
    public void turnRight(int ticks)
    {
        switch (count) {
            case 1:
                secA = ticks;
                count++;
                break;
            case 3:
                secC = ticks;
                count++;
                break;
            default:
                open = false;
                break;
        }
    }
    
    public boolean open()
    {
        if (open)
        {
            return secA == secretA && secB == secretB && secC == secretC;
        }
        
        else
        {
            return false;
        }
    }
    
    public static void main(String args[])
    {
        Lock combo = new Lock(2,3,4);
        
        System.out.println("\nReset the lock so its locked "
                + "and using lock code 6,7,8");
        combo.reset();
        System.out.println("\nTurn the lock left by 6 ticks");
        combo.turnLeft(6);
        
        System.out.println("Turn the lock right by 7 ticks");
        combo.turnRight(7);
        
        System.out.println("Turn the lock left by 8 ticks");
        combo.turnLeft(8);
        
        System.out.println("\nThe lock is open: "+combo.open());
        
        System.out.println("\nReset the lock so its locked"
                + "and using lock code 2,3,4");
        combo.reset();
        
        System.out.println("\nTurn the lock right by 2 ticks");
        combo.turnRight(2);
        
        System.out.println("Turn the lock left by 3 ticks");
        combo.turnLeft(3);
        
        System.out.println("Turn the lock right by 4 ticks");
        combo.turnRight(4);
        
        System.out.println("\nThe lock is open: "+combo.open());
        combo.reset();
        
    }
    
}
